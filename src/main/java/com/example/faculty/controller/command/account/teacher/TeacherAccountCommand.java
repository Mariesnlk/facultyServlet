package com.example.faculty.controller.command.account.teacher;

import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TeacherAccountCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return RoutesJSP.TEACHER_ACCOUNT;
    }
}
