package com.example.faculty.utils;

import com.example.faculty.model.enums.UserRole;

import java.util.*;

import static com.example.faculty.controller.command.PathCommand.*;


public class SecurityConfig {

    private static final Map<UserRole, List<String>> mapConfig = new HashMap<>();

    static {
        init();
    }

    private static void init() {
        List<String> urlPatterns1 = new ArrayList<>();

        urlPatterns1.add(STUDENT_ACCOUNT);
        urlPatterns1.add(ALL_COURSES);
        urlPatterns1.add(STUDENT_COURSES);
        urlPatterns1.add(UPDATE_USER);
        urlPatterns1.add(ALL_TEACHERS);
        urlPatterns1.add(LOGOUT);

        mapConfig.put(UserRole.STUDENT, urlPatterns1);

        List<String> urlPatterns2 = new ArrayList<>();
        urlPatterns2.add(TEACHER_ACCOUNT);
        urlPatterns2.add(UPDATE_USER);
        urlPatterns2.add(TEACHER_COURSES);
        urlPatterns2.add(LOGOUT);

        mapConfig.put(UserRole.TEACHER, urlPatterns2);

        List<String> urlPatterns3 = new ArrayList<>();
        urlPatterns3.add(ADMIN_ACCOUNT);
        urlPatterns3.add(BLOCK_STUDENT);
        urlPatterns3.add(ADD_TOPIC);
        urlPatterns3.add(UPDATE_TOPIC);
        urlPatterns3.add(ALL_TOPICS);
        urlPatterns3.add(ALL_COURSES);
        urlPatterns3.add(ADD_COURSES);
        urlPatterns3.add(UPDATE_COURSES);
        urlPatterns3.add(ALL_STUDENTS);
        urlPatterns3.add(ALL_TEACHERS);
        urlPatterns3.add(ADD_TEACHER);
        urlPatterns3.add(ALL_TOPICS_PAG);
        urlPatterns3.add(UPDATE_USER);
        urlPatterns3.add(LOGOUT);

        mapConfig.put(UserRole.ADMINISTRATOR, urlPatterns3);
    }

    public static Set<UserRole> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(UserRole role) {
        return mapConfig.get(role);
    }
}
