package com.example.faculty.controller.command.account.student;


import com.example.faculty.cipher.AES;
import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;
import com.example.faculty.exception.EmailIsAlreadyTaken;
import com.example.faculty.model.domain.User;
import com.example.faculty.model.enums.UserRole;
import com.example.faculty.service.interf.UserService;
import com.example.faculty.utils.InputDataRegistrationUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static com.example.faculty.controller.command.PathCommand.LOGIN;
import static com.example.faculty.controller.command.PathCommand.REDIRECT;


public class RegistrationCommand implements Command {

    private final Logger LOGGER = Logger.getLogger(RegistrationCommand.class);

    private UserService userService;

    public RegistrationCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("start post ");
        final String firstName = request.getParameter("firstName");
        final String secondName = request.getParameter("secondName");
        final String lastName = request.getParameter("lastName");
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        final String confirmPassword = request.getParameter("confirmPassword");

        if (firstName == null || secondName == null || lastName == null) {
            return RoutesJSP.REGISTER_PAGE;
        }
        if (InputDataRegistrationUtils.isNotCorrectData(firstName, secondName, lastName,
                email, password, confirmPassword)) {
            return RoutesJSP.REGISTER_PAGE + "?badInput=true";
        }

        User user = new User.Builder()
                .setDate(new Date())
                .setFirstName(firstName)
                .setSecondName(secondName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(AES.encrypt(password, AES.KEY))
                .setRole(UserRole.STUDENT)
                .build();


        try {
            userService.create(user);
        } catch (EmailIsAlreadyTaken emailIsAlreadyTaken) {
            emailIsAlreadyTaken.printStackTrace();
            return RoutesJSP.REGISTER_PAGE + "?badEmail=true";
        }
        String contextAndServletPath = request.getContextPath() + request.getServletPath();

        return REDIRECT + contextAndServletPath + LOGIN;
    }
}
