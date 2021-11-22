package com.example.faculty.dao.impl;

import com.example.faculty.dao.interf.GradeBookDto;
import com.example.faculty.model.domain.GradeBook;
import com.example.faculty.model.entity.CourseEntity;
import com.example.faculty.model.entity.GradeBookEntity;
import com.example.faculty.model.entity.UserEntity;

import java.util.List;
import java.util.logging.Logger;

public class GradeBookDaoImpl implements GradeBookDto {

    private static final Logger LOG = Logger.getLogger(GradeBookDaoImpl.class.getName());

    @Override
    public void create(GradeBookEntity entity) {

    }

    @Override
    public GradeBookEntity findById(Long id) {
        return null;
    }

    @Override
    public List<GradeBookEntity> findAll() {
        return null;
    }

    @Override
    public void update(GradeBookEntity entity) {

    }

    @Override
    public boolean delete(GradeBookEntity entity) {
        return false;
    }

    @Override
    public Boolean existsGradeBookByCourseAndStudent(CourseEntity courseEntity, UserEntity student) {
        return null;
    }

    @Override
    public GradeBookEntity findGradeBookByCourseAndStudent(CourseEntity courseEntity, UserEntity student) {
        return null;
    }
}
