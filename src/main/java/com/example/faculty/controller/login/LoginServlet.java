package com.example.faculty.controller.login;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/login/login.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("userLogin");
        String password = request.getParameter("userPassword");

//        EmployeeService employeeService = new EmployeeServiceImpl();
//        Employee registeredEmployee = employeeService.getRegisteredEmployee(login, password);
//
//        HttpSession session = request.getSession();
//        session.setAttribute("registeredEmployee", registeredEmployee);
//        String resultPage = "views/login/loginResult.jsp";
//
//        if (registeredEmployee.getRole().equalsIgnoreCase("cashier")) {
//            response.sendRedirect("/index-cashier");
//
//        } else if (registeredEmployee.getRole().equalsIgnoreCase("manager")) {
//            response.sendRedirect("/index-manager");
//
//        } else {
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher(resultPage);
//            LOGGER.info("doPost process");
//            requestDispatcher.forward(request, response);
//        }
    }
}
