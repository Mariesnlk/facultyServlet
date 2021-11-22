package com.example.faculty.controller.command;

public interface RoutesJSP {
    // TODO: 22.11.2021 add all 
    String STUDENT_ACCOUNT = "/jsp/accountStudent/studentAccount.jsp";
    String TEACHER_ACCOUNT = "/jsp/accountTeacher/teacherAccount.jsp";
    String ADMIN_ACCOUNT = "/jsp/accountAdmin/adminAccount.jsp";
    
    String HOME = "/jsp/commonPages/home.jsp";
    
    String REGISTER_STUDENT = "/jsp/commonPages/registerStudent.jsp";
    String REGISTER_TEACHER = "/jsp/commonPages/registerTeacher.jsp";
    
    String LOGIN = "/jsp/commonPages/login.jsp";
    String HTTP_FORBIDDEN = "/jsp/error/403.jsp";

}
