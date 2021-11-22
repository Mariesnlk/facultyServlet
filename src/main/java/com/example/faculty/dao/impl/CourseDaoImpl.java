package com.example.faculty.dao.impl;

import com.example.faculty.dao.interf.CourseDao;
import com.example.faculty.model.entity.CourseEntity;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class CourseDaoImpl implements CourseDao {

    private static final Logger LOG = Logger.getLogger(CourseDaoImpl.class.getName());

    @Override
    public Optional<CourseEntity> findCourseByCourseId(Long courseId) {
        return Optional.empty();
    }

    @Override
    public Boolean existsCourseByName(String name) {
        return null;
    }

    @Override
    public void create(CourseEntity entity) {

    }

    @Override
    public CourseEntity findById(Long id) {
        return null;
    }

    @Override
    public List<CourseEntity> findAll() {
        return null;
    }

    @Override
    public void update(CourseEntity entity) {

    }

    @Override
    public boolean delete(CourseEntity entity) {
        return false;
    }
}
