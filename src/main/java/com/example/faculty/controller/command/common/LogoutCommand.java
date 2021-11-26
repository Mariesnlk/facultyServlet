package com.example.faculty.controller.command.common;

import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.PathCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.invalidate();
        String contextAndServletPath = request.getContextPath() + request.getServletPath();
        return PathCommand.REDIRECT + contextAndServletPath + PathCommand.HOME_PAGE + "?logout=true";
    }
}
