package com.example.faculty.service.impl;

import com.example.faculty.model.domain.Course;
import com.example.faculty.model.domain.Enroll;
import com.example.faculty.model.domain.User;
import com.example.faculty.service.interf.EnrollService;

import java.util.List;

public class EnrollServiceImpl implements EnrollService {
    @Override
    public void create(Enroll entity) {

    }

    @Override
    public Enroll findById(Long id) {
        return null;
    }

    @Override
    public List<Enroll> findAll() {
        return null;
    }

    @Override
    public void update(Enroll entity) {

    }

    @Override
    public boolean delete(Enroll entity) {
        return false;
    }

    @Override
    public void enroll(User student, Course course) {

    }
}
