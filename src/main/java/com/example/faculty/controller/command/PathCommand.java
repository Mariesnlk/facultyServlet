package com.example.faculty.controller.command;

public interface PathCommand {
    String REGISTER_USER = "/registerUser";

    String REGISTER_STUDENT = "/registerStudent";
    String REGISTER_TEACHER = "/registerTeacher";
    String REGISTER_PAGE = "/register";

    String HOME_PAGE = "/homePage";
    String ENTER_LOGIN = "/enterLogin";
    String LOGIN_PAGE = "/login";
    String LOGOUT = "/logOut";

    String STUDENT_ACCOUNT = "/studentAccount";
    String TEACHER_ACCOUNT = "/teacherAccount";
    String ADMIN_ACCOUNT = "/adminAccount";

    String BLOCK_STUDENT = "/blockStudent";
    String ADD_TOPIC = "/addTopic";
    String UPDATE_TOPIC = "/updateTopic";
    String ALL_TOPICS = "/allTopics";
    String FORBIDDEN = "/forbidden";
    String REDIRECT = "redirect#";
    String EMPTY_STR = "";
}
