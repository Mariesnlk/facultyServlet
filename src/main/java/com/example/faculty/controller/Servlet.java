package com.example.faculty.controller;


import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.context.ApplicationContextInjector;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static com.example.faculty.controller.command.PathCommand.*;

public class Servlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(Servlet.class);
    private Map<String, Command> commands;

    @Override
    public void init() {
        ApplicationContextInjector injector = ApplicationContextInjector.getInstance();
        commands = injector.getNameCommandToCommands();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOGGER.info("doGet process");
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOGGER.info("doPost process");
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String commandKey = getRequestPath(request);
        LOGGER.info("get command");
        LOGGER.info(commandKey);
        Command command = commands.get(commandKey);
        String contextAndServletPath = request.getContextPath() + request.getServletPath();
        if (command == null) {
            response.sendRedirect(contextAndServletPath + HOME_PAGE);
        } else {
            String nextPage = command.execute(request, response);
            if (isRedirect(nextPage)) {
                response.sendRedirect(nextPage.replaceAll(REDIRECT, EMPTY_STR));
            } else {
                request.getRequestDispatcher(nextPage).forward(request, response);
            }
        }
    }

    private String getRequestPath(HttpServletRequest request) {
        String pathURI = request.getRequestURI();
        String servletPath = request.getServletPath();
        String regex = ".*" + servletPath;
        return pathURI.replaceAll(regex, EMPTY_STR);
    }

    private boolean isRedirect(String string) {
        return string.contains(REDIRECT);
    }
}
