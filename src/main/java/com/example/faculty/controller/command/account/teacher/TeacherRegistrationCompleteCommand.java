package com.example.faculty.controller.command.account.teacher;

import com.example.faculty.cipher.AES;
import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;
import com.example.faculty.model.domain.User;
import com.example.faculty.service.interf.UserService;
import com.example.faculty.utils.InputDataValidationUtils;
import com.example.faculty.utils.LoginUserUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.faculty.controller.command.PathCommand.LOGIN;
import static com.example.faculty.controller.command.PathCommand.REDIRECT;

public class TeacherRegistrationCompleteCommand implements Command {

    private final Logger LOGGER = Logger.getLogger(TeacherRegistrationCompleteCommand.class);

    private UserService userService;

    public TeacherRegistrationCompleteCommand(UserService userService) {
        this.userService = userService;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.info("complete registration teacher start");

        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        final String confirmPassword = request.getParameter("confirmPassword");

        if (InputDataValidationUtils.isCorrectEmail(email) && InputDataValidationUtils.isSamePassword(password, confirmPassword)) {

            try {

                User teacher = userService.findTeacherByEmail(email);
                teacher.setPassword(AES.encrypt(password, AES.KEY));
                userService.update(teacher);

                return RoutesJSP.IS_TEACHER + "?register=true";

            } catch (Exception e) {
                e.printStackTrace();
                return RoutesJSP.IS_TEACHER + "?notExistEmail=true";
            }

        } else {
            return RoutesJSP.IS_TEACHER + "?badInput=true";
        }
    }
}
