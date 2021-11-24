package com.example.faculty.controller.command;

public interface RoutesJSP {
    String STUDENT_ACCOUNT = "/jsp/student/student-account.jsp";
    String TEACHER_ACCOUNT = "/jsp/teacher/teacher-account.jsp";
    String ADMIN_ACCOUNT = "/jsp/admin/admin-account.jsp";
    
    String HOME = "/index.jsp";
    
    String REGISTER = "/jsp/registration.jsp";
    
    String LOGIN = "/jsp/login.jsp";
    String LOGOUT = "/logout";
    String ABOUT = "/jsp/about.jsp";
    String CONTACTS = "/jsp/contacts.jsp";
    String HTTP_FORBIDDEN = "/jsp/error/403.jsp";

    String ADD_TOPIC = "/jsp/topic/add-topic.jsp";
    String UPDATE_TOPIC = "/jsp/topic/update-topic.jsp";
    String ALL_TOPICS = "/jsp/topic/all-topics.jsp";

    String ALL_COURSES = "/jsp/course/all-courses.jsp";
    String ADD_COURSES = "/jsp/course/add-course.jsp";
    String UPDATE_COURSES = "/jsp/course/update-course.jsp";

    String ALL_STUDENTS = "/jsp/student/all-students.jsp";
    String UPDATE_STUDENT = "/jsp/student/update-student.jsp";
    String STUDENT_COURSES = "/jsp/course/student-courses.jsp";

    String ALL_TEACHERS = "/jsp/teacher/all-teachers.jsp";
    String ADD_TEACHER = "/jsp/teacher/add-teacher.jsp";
    String UPDATE_TEACHER = "/jsp/teacher/update-teacher.jsp";
    String TEACHER_COURSES = "/jsp/course/teacher-courses.jsp";

    String REDIRECT = "redirect#";
    String EMPTY_STR = "";

}
