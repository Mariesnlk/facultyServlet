package com.example.faculty.controller.command.account.admin;

import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminAccountCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        return RoutesJSP.ADMIN_ACCOUNT;
    }
}
