package com.example.faculty.utils;

import com.example.faculty.model.domain.User;

import javax.servlet.http.HttpSession;


public class LoginUserUtils {

    private static final String SESSION_ATTRIBUTE = "loginPerson";

    public static void storeLoginUser(HttpSession session, User loginPerson) {
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
