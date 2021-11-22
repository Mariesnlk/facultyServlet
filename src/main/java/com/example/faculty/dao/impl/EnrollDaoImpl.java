package com.example.faculty.dao.impl;

import com.example.faculty.dao.interf.EnrollDao;
import com.example.faculty.model.domain.Enroll;
import com.example.faculty.model.entity.CourseEntity;
import com.example.faculty.model.entity.EnrollEntity;
import com.example.faculty.model.entity.UserEntity;

import java.util.List;
import java.util.logging.Logger;

public class EnrollDaoImpl implements EnrollDao {

    private static final Logger LOG = Logger.getLogger(EnrollDaoImpl.class.getName());

    @Override
    public void create(EnrollEntity entity) {

    }

    @Override
    public EnrollEntity findById(Long id) {
        return null;
    }

    @Override
    public List<EnrollEntity> findAll() {
        return null;
    }

    @Override
    public void update(EnrollEntity entity) {

    }

    @Override
    public boolean delete(EnrollEntity entity) {
        return false;
    }

    @Override
    public Boolean existsEnrollByCourseAndUser(CourseEntity courseEntity, UserEntity userEntity) {
        return null;
    }

    @Override
    public void deleteByCourseAndUser(CourseEntity courseEntity, UserEntity userEntity) {

    }
}
