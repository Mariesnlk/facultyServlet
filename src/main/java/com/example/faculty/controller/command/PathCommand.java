package com.example.faculty.controller.command;

public interface PathCommand {
    String REGISTER_USER = "/register";

//    String REGISTER_STUDENT = "/registerStudent";
//    String REGISTER_TEACHER = "/registerTeacher";

    String HOME_PAGE = "/homePage";
    String LOGIN = "/login";
    String LOGOUT = "/logout";
    String ABOUT = "/about";
    String CONTACTS = "/contacts";

    String STUDENT_ACCOUNT = "/studentAccount";
    String TEACHER_ACCOUNT = "/teacherAccount";
    String ADMIN_ACCOUNT = "/adminAccount";

    String BLOCK_STUDENT = "/block_student";

    String ADD_TOPIC = "/add_topic";
    String UPDATE_TOPIC = "/update_topic";
    String ALL_TOPICS = "/topics";

    String ALL_COURSES = "/courses";
    String ADD_COURSES = "/add_course";
    String UPDATE_COURSES = "/update_course";

    String ALL_STUDENTS = "/students";
    String UPDATE_STUDENT = "/update_student";
    String STUDENT_COURSES = "/my_courses";

    String ALL_TEACHERS = "/teachers";
    String ADD_TEACHER = "/add_teacher";
    String UPDATE_TEACHER = "/update_teacher";
    String TEACHER_COURSES = "/teacher/my_courses";

    String FORBIDDEN = "/forbidden";
    String REDIRECT = "redirect#";
    String EMPTY_STR = "";
}
