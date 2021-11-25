package com.example.faculty.controller.command;

public interface RoutesJSP {
    String STUDENT_ACCOUNT = "/WEB-INF/jsp/student/student-account.jsp";
    String TEACHER_ACCOUNT = "/WEB-INF/jsp/teacher/teacher-account.jsp";
    String ADMIN_ACCOUNT = "/WEB-INF/jsp/admin/admin-account.jsp";
    
    String HOME = "/index.jsp";
    
    String REGISTER_PAGE = "/WEB-INF/jsp/registration.jsp";
    
    String LOGIN = "/WEB-INF/jsp/login.jsp";
    String LOGOUT = "/WEB-INF/logout";
    String ABOUT = "/WEB-INF/jsp/about.jsp";
    String CONTACTS = "/WEB-INF/jsp/contacts.jsp";
    String HTTP_FORBIDDEN = "/WEB-INF/jsp/error/403.jsp";

    String ADD_TOPIC = "/WEB-INF/jsp/topic/add-topic.jsp";
    String UPDATE_TOPIC = "/WEB-INF/jsp/topic/update-topic.jsp";
    String ALL_TOPICS = "/WEB-INF/jsp/topic/all-topics.jsp";

    String ALL_COURSES = "/WEB-INF/jsp/course/all-courses.jsp";
    String ADD_COURSES = "/WEB-INF/jsp/course/add-course.jsp";
    String UPDATE_COURSES = "/WEB-INF/jsp/course/update-course.jsp";

    String ALL_STUDENTS = "/WEB-INF/jsp/student/all-students.jsp";
    String UPDATE_STUDENT = "/WEB-INF/jsp/student/update-student.jsp";
    String STUDENT_COURSES = "/WEB-INF/jsp/course/student-courses.jsp";

    String ALL_TEACHERS = "/WEB-INF/jsp/teacher/all-teachers.jsp";
    String ADD_TEACHER = "/WEB-INF/jsp/teacher/add-teacher.jsp";
    String UPDATE_TEACHER = "/WEB-INF/jsp/teacher/update-teacher.jsp";
    String TEACHER_COURSES = "/WEB-INF/jsp/course/teacher-courses.jsp";

    String REDIRECT = "redirect#";
    String EMPTY_STR = "";

}
