package com.example.faculty.controller.command.common;

import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;
import com.example.faculty.controller.command.account.student.RegistrationCommand;
import com.example.faculty.exception.EmailIsAlreadyTaken;
import com.example.faculty.model.domain.User;
import com.example.faculty.model.enums.UserRole;
import com.example.faculty.service.interf.UserService;
import com.example.faculty.utils.InputDataValidationUtils;
import com.example.faculty.utils.LoginUserUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static com.example.faculty.controller.command.PathCommand.*;

public class UpdateCommand implements Command {

    private final Logger LOGGER = Logger.getLogger(UpdateCommand.class);

    private UserService userService;

    public UpdateCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.info("UpdateCommand - start update ");
        final String firstName = request.getParameter("firstName");
        final String secondName = request.getParameter("secondName");
        final String lastName = request.getParameter("lastName");
        final String email = request.getParameter("email");

        String contextAndServletPath = request.getContextPath() + request.getServletPath();
        User user = LoginUserUtils.getLoginUser(request.getSession());
        LOGGER.info("user - " + user);
        String userRole = null;
        if (user != null) {

            if (UserRole.STUDENT.toString().equals(user.getRole().toString())) {
                userRole = UserRole.STUDENT.name();
            } else if (UserRole.TEACHER.toString().equals(user.getRole().toString())) {
                userRole = UserRole.TEACHER.name();
            } else {
                userRole = UserRole.ADMINISTRATOR.name();
            }

            if (firstName == null || secondName == null || lastName == null) {
                if (userRole.equals(UserRole.STUDENT.name())) {
                    return RoutesJSP.STUDENT_ACCOUNT;
                } else if (userRole.equals(UserRole.TEACHER.name())) {
                    return RoutesJSP.TEACHER_ACCOUNT;
                } else {
                    return RoutesJSP.ADMIN_ACCOUNT;
                }
            }
            if (InputDataValidationUtils.isNotCorrectData(firstName, secondName, lastName, email)) {
                if (userRole.equals(UserRole.STUDENT.name())) {
                    return RoutesJSP.STUDENT_ACCOUNT + "?badInput=true";
                } else if (userRole.equals(UserRole.TEACHER.name())) {
                    return RoutesJSP.TEACHER_ACCOUNT + "?badInput=true";
                } else {
                    return RoutesJSP.ADMIN_ACCOUNT + "?badInput=true";
                }
            }

            User userToUpdate = userService.findById(user.getUserId());
            userToUpdate.setDate(new Date());
            userToUpdate.setFirstName(firstName);
            userToUpdate.setSecondName(secondName);
            userToUpdate.setLastName(lastName);
            userToUpdate.setEmail(email);


            try {
                userService.update(userToUpdate);
            } catch (EmailIsAlreadyTaken emailIsAlreadyTaken) {
                emailIsAlreadyTaken.printStackTrace();
                return RoutesJSP.REGISTER_PAGE + "?badInput=true";
            }

            if (UserRole.STUDENT.toString().equals(user.getRole().toString())) {
                LoginUserUtils.updateLoginUser(request.getSession(), userToUpdate);
                return REDIRECT + contextAndServletPath + STUDENT_ACCOUNT;
            } else if (UserRole.TEACHER.toString().equals(user.getRole().toString())) {
                LoginUserUtils.updateLoginUser(request.getSession(), userToUpdate);
                return REDIRECT + contextAndServletPath + TEACHER_ACCOUNT;
            } else {
                LoginUserUtils.updateLoginUser(request.getSession(), userToUpdate);
                return REDIRECT + contextAndServletPath + ADMIN_ACCOUNT;
            }

        }

        return REDIRECT + contextAndServletPath + HOME_PAGE;
    }
}
