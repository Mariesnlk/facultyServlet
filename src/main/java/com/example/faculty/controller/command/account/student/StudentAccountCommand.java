package com.example.faculty.controller.command.account.student;

import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StudentAccountCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return RoutesJSP.STUDENT_ACCOUNT;
    }
}
