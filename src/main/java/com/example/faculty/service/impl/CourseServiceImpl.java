package com.example.faculty.service.impl;

import com.example.faculty.model.domain.Course;
import com.example.faculty.service.interf.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    @Override
    public void create(Course entity) {

    }

    @Override
    public Course findById(Long id) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public void update(Course entity) {

    }

    @Override
    public boolean delete(Course entity) {
        return false;
    }

    @Override
    public List<String> findAllCourseNames() {
        return null;
    }

    @Override
    public List<Integer> findAllDurations() {
        return null;
    }

    @Override
    public List<Integer> findAllStudentsAmount() {
        return null;
    }

    @Override
    public List<String> findCourseNameByName(String name) {
        return null;
    }

    @Override
    public List<String> findAllTopics() {
        return null;
    }

    @Override
    public List<Integer> findAllTeacherNames() {
        return null;
    }

    @Override
    public List<Integer> findTeacherIdByName(String name) {
        return null;
    }
}
