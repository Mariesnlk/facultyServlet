package com.example.faculty.utils;

import com.example.faculty.model.domain.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;


public class LoginUserUtils {

    private static final Logger LOGGER = Logger.getLogger(LoginUserUtils.class);

    private static final String SESSION_ATTRIBUTE = "loginPerson";

    public static void storeLoginUser(HttpSession session, User loginPerson) {
        LOGGER.info(loginPerson);
        session.setAttribute(SESSION_ATTRIBUTE, loginPerson);
    }

    public static User getLoginUser(HttpSession session) {
        return (User) session.getAttribute(SESSION_ATTRIBUTE);
    }

    public static void updateLoginUser(HttpSession session, User loginPerson) {
        session.removeAttribute(SESSION_ATTRIBUTE);
        session.setAttribute(SESSION_ATTRIBUTE, loginPerson);
    }
}
