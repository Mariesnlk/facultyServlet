package com.example.faculty.service.impl;

import com.example.faculty.model.domain.Course;
import com.example.faculty.model.domain.GradeBook;
import com.example.faculty.model.domain.User;
import com.example.faculty.service.interf.GradeBookService;

import java.util.List;

public class GradeBookServiceImpl implements GradeBookService {
    @Override
    public void create(GradeBook entity) {

    }

    @Override
    public GradeBook findById(Long id) {
        return null;
    }

    @Override
    public List<GradeBook> findAll() {
        return null;
    }

    @Override
    public void update(GradeBook entity) {

    }

    @Override
    public boolean delete(GradeBook entity) {
        return false;
    }

    @Override
    public void saveMark(User student, Course course, Integer mark) {

    }
}
