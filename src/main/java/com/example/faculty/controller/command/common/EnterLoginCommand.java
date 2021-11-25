package com.example.faculty.controller.command.common;

import com.example.faculty.cipher.AES;
import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;
import com.example.faculty.model.domain.User;
import com.example.faculty.model.enums.UserRole;
import com.example.faculty.service.interf.UserService;
import com.example.faculty.utils.LoginUserUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.example.faculty.controller.command.PathCommand.*;


public class EnterLoginCommand implements Command {

    private final Logger LOGGER = Logger.getLogger(EnterLoginCommand.class);

    private UserService userService;

    public EnterLoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        LOGGER.info("email" + email + " password " + password);

        String contextAndServletPath = request.getContextPath() + request.getServletPath();
        String hashPassword = AES.encrypt(password, AES.KEY);
        LOGGER.info(" hashPassword " + hashPassword);

        if (inputWrongData(email, hashPassword)) {
            LOGGER.info(inputWrongData(email, hashPassword));
            request.setAttribute("errorMessage", "Invalid password or email");
            return RoutesJSP.LOGIN + "?wrongData=true";
        } else {
            User user = LoginUserUtils.getLoginUser(request.getSession());
            if (user != null) {

                if (UserRole.STUDENT.toString().equals(user.getRole().toString())) {
                    return REDIRECT + contextAndServletPath + STUDENT_ACCOUNT;
                } else if (UserRole.TEACHER.toString().equals(user.getRole().toString())) {
                    return REDIRECT + contextAndServletPath + TEACHER_ACCOUNT;
                } else {
                    return REDIRECT + contextAndServletPath + ADMIN_ACCOUNT;
                }
            }
            if (checkIfStudent(email, hashPassword)) {
                user = userService.getUserByEmailAndPassword(email, hashPassword);
                LoginUserUtils.storeLoginUser(request.getSession(), user);
                LOGGER.info(LoginUserUtils.getLoginUser(request.getSession()));

                return REDIRECT + contextAndServletPath + STUDENT_ACCOUNT;
            } else if (checkIfTeacher(email, hashPassword)) {
                user = userService.getUserByEmailAndPassword(email, hashPassword);
                LoginUserUtils.storeLoginUser(request.getSession(), user);
                return REDIRECT + contextAndServletPath + TEACHER_ACCOUNT;
            } else {
                user = userService.getUserByEmailAndPassword(email, hashPassword);
                LoginUserUtils.storeLoginUser(request.getSession(), user);
                return REDIRECT + contextAndServletPath + ADMIN_ACCOUNT;
            }
        }
    }

    private boolean inputWrongData(String email, String password) {
        return !checkIfAdmin(email, password) && !checkIfTeacher(email, password) && !checkIfStudent(email, password);
    }

    private boolean checkIfAdmin(String email, String password) {
        LOGGER.info("admin - " + userService.isAdminExists(email, password));
        return userService.isAdminExists(email, password);
    }

    private boolean checkIfStudent(String email, String password) {
        LOGGER.info("student - " + userService.isStudentExists(email, password));
        return userService.isStudentExists(email, password);
    }

    private boolean checkIfTeacher(String email, String password) {
        LOGGER.info("teacher - " + userService.isTeacherExists(email, password));
        return userService.isTeacherExists(email, password);
    }
}
