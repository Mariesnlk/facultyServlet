package com.example.faculty.utils;

import com.example.faculty.model.enums.UserRole;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;


public class SecurityUtils {

    public static boolean isSecurityPage(HttpServletRequest request) {
        Set<UserRole> roles = SecurityConfig.getAllAppRoles();
        for (UserRole role : roles) {
            List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
            if (urlPatterns != null && urlPatterns.contains(request.getPathInfo())) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasPermission(HttpServletRequest request, UserRole personRole) {
        return SecurityConfig.getUrlPatternsForRole(personRole).contains(request.getPathInfo());
    }
}
