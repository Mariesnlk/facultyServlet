package com.example.faculty.controller.command.account.admin.user;

import com.example.faculty.cipher.AES;
import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;
import com.example.faculty.exception.EmailIsAlreadyTaken;
import com.example.faculty.model.domain.User;
import com.example.faculty.model.enums.UserRole;
import com.example.faculty.service.interf.UserService;
import com.example.faculty.utils.InputDataValidationUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static com.example.faculty.controller.command.PathCommand.ALL_TEACHERS_PAG;
import static com.example.faculty.controller.command.RoutesJSP.REDIRECT;

public class AddTeacher implements Command {

    private final Logger LOGGER = Logger.getLogger(AddTeacher.class);

    private UserService userService;

    public AddTeacher(UserService userService) {
        this.userService = userService;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.info("start register teacher");
        final String firstName = request.getParameter("firstName");
        final String secondName = request.getParameter("secondName");
        final String lastName = request.getParameter("lastName");
        final String email = request.getParameter("email");

        if (InputDataValidationUtils.isCorrectEmail(email) && !(userService.isTeacherWithEmailExists(email))) {
            if (!(InputDataValidationUtils.isNotCorrectData(firstName, secondName, lastName, email))) {

                userService.create(
                        new User.Builder()
                                .setDate(new Date())
                                .setFirstName(firstName)
                                .setSecondName(secondName)
                                .setLastName(lastName)
                                .setEmail(email)
                                .setPassword("")
                                .setRole(UserRole.TEACHER)
                                .build());

                LOGGER.info("register teacher");
                String contextAndServletPath = request.getContextPath() + request.getServletPath();
                return REDIRECT + contextAndServletPath + ALL_TEACHERS_PAG + "?pagination=1";
            } else {
                return RoutesJSP.ADD_TEACHER + "?badInput=true";
            }
        } else {
            return RoutesJSP.ADD_TEACHER + "?notValidEmail=true";
        }
    }
}
