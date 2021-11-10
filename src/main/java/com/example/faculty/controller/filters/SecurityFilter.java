package com.example.faculty.controller.filters;

import com.example.faculty.model.entities.User;
import com.example.faculty.model.enums.UserRole;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        UserRole userRole = null;

        User user = (User) session.getAttribute("registeredUser");

        String[] urlAccessStudent = {"/", "/login", "/images/**", "/css/**"};

        String[] urlAccessTeacher = {"/", "/login", "/images/**", "/css/**"};

        String[] urlAccessAdministrator = {"/", "/login", "/images/**", "/css/**"};

        if (user != null) {
            userRole = user.getRole();
        }
        String currentUrl = httpRequest.getRequestURI();

        if (currentUrl.equals("/login")) {
            chain.doFilter(request, response);

        } else if (userRole == null) {
            httpResponse.sendRedirect("/login");

        } else if (userRole.equals(UserRole.STUDENT) && !checkAccess(currentUrl, urlAccessStudent)) {
            httpResponse.sendRedirect("/login");

        } else if (userRole.equals(UserRole.TEACHER) && !checkAccess(currentUrl, urlAccessTeacher)) {
            httpResponse.sendRedirect("/login");

        } else if (userRole.equals(UserRole.ADMINISTRATOR) && !checkAccess(currentUrl, urlAccessAdministrator)) {
            httpResponse.sendRedirect("/login");

        } else {
            chain.doFilter(request, response);

        }

    }

    @Override
    public void destroy() {

    }

    boolean checkAccess(String url, String[] accessUrls) {

      /*   /employee/**
         /employee/111
        */

        for (String strUrl : accessUrls) {
            if (strUrl.equals(url)) {
                return true;
            }

            if (strUrl.contains("**")) {
                String[] pathUserElems = url.split("/");
                String[] parthsElems = strUrl.split("/");
                String strWithout = "";
                String strUserWithout = "";
                int count = 0;
                for (String elem : parthsElems) {
                    if (!elem.equalsIgnoreCase("**")) {
                        strWithout += elem;
                        strUserWithout += pathUserElems[count];
                    }
                    count++;

                }
                if (strWithout.equalsIgnoreCase(strUserWithout)) {
                    return true;
                }
            }
        }

        return false;
    }

}
