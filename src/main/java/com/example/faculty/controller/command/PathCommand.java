package com.example.faculty.controller.command;

public interface PathCommand {

    String REGISTER_PAGE = "/register_form";
    String REGISTER_USER = "/register";

    String UPDATE_USER = "/update";
    String UPDATE_STUDENT_FORM = "/student/update_form";
    String UPDATE_ADMIN_FORM = "/admin/update_form";

    String HOME_PAGE = "/home";
    String LOGIN = "/login";
    String LOGIN_PAGE = "/login_form";
    String LOGOUT = "/logout";
    String ABOUT = "/about";
    String CONTACTS = "/contacts";

    String STUDENT_ACCOUNT = "/studentAccount";
    String TEACHER_ACCOUNT = "/teacherAccount";
    String ADMIN_ACCOUNT = "/adminAccount";

    String BLOCK_STUDENT = "/block_student";

    String ADD_TOPIC = "/add_topic";
    String ADD_TOPIC_FORM = "/add_topic_form";
    String UPDATE_TOPIC = "/update_topic";
    String UPDATE_TOPIC_FORM = "/update_topic_form";
    String ALL_TOPICS = "/topics";
    String ALL_TOPICS_PAG = "/all_topics";
    String DELETE_TOPIC_PATH = "/delete_topic";

    String ALL_COURSES = "/courses";
    String ALL_COURSES_PAG = "/all_courses";
    String ADD_COURSES = "/add_course";
    String UPDATE_COURSES = "/update_course";

    String ALL_STUDENTS = "/students";
    String ALL_STUDENTS_PAG = "/all_students";
    String STUDENT_COURSES = "/my_courses";

    String ALL_TEACHERS = "/teachers";
    String ALL_TEACHERS_PAG = "/all_teachers";
    String ADD_TEACHER = "/add_teacher";
    String ADD_TEACHER_FORM = "/teacher_form";
    String TEACHER_COURSES = "/teacher/my_courses";
    String UPDATE_TEACHER_FORM = "/teacher/update_form";
    String IS_TEACHER = "/is_teacher";
    String TEACHER_REGISTRATION_COMPLETE = "/teacher/registration";

    String FORBIDDEN = "/forbidden";
    String REDIRECT = "redirect#";
    String EMPTY_STR = "";
}
