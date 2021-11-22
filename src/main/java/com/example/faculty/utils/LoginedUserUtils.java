package com.example.faculty.utils;

import com.example.faculty.model.domain.User;

import javax.servlet.http.HttpSession;


public class LoginedUserUtils {

    private static final String SESSION_ATTRIBUTE = "loginedPerson";

    public static void storeLoginedUser(HttpSession session, User loginedPerson) {
        session.setAttribute(SESSION_ATTRIBUTE, loginedPerson);
    }

    public static User getLoginedUser(HttpSession session) {
        return (User) session.getAttribute(SESSION_ATTRIBUTE);
    }

    public static void updateLoginedUser(HttpSession session, User loginedPerson) {
        session.removeAttribute(SESSION_ATTRIBUTE);
        session.setAttribute(SESSION_ATTRIBUTE, loginedPerson);
    }
}
