package com.example.faculty.controller.filters;

import com.example.faculty.model.domain.User;
import com.example.faculty.model.enums.UserRole;
import com.example.faculty.utils.LoginUserUtils;
import com.example.faculty.utils.SecurityUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.faculty.controller.command.PathCommand.*;


public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig fConfig) {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String pathInfo = request.getPathInfo();
        String contextAndServletPath = request.getContextPath() + request.getServletPath();
        User loginUser = LoginUserUtils.getLoginUser(request.getSession());

        if ((LOGIN_PAGE.equals(pathInfo) || REGISTER_USER.equals(pathInfo)) && loginUser != null) {
            if (loginUser.getRole().equals(UserRole.STUDENT)) {
                response.sendRedirect(contextAndServletPath + STUDENT_ACCOUNT);
            } else  if (loginUser.getRole().equals(UserRole.TEACHER)){
                response.sendRedirect(contextAndServletPath + TEACHER_ACCOUNT);
            }else {
                response.sendRedirect(contextAndServletPath + ADMIN_ACCOUNT);
            }
            return;
        }

        if (SecurityUtils.isSecurityPage(request)) {
            if (loginUser != null && SecurityUtils.hasPermission(request, loginUser.getRole())) {

                chain.doFilter(req, resp);
            } else {
//                if (MAKE_ORDER.equals(pathInfo)) {
//                    response.sendRedirect(contextAndServletPath + LOGIN_PAGE);
//                } else {
//                    response.sendRedirect(contextAndServletPath + FORBIDDEN);
//                }
            }
        } else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {
    }
}
