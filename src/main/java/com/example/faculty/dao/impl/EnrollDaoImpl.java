package com.example.faculty.dao.impl;

import com.example.faculty.dao.interf.EnrollDao;
import com.example.faculty.model.entities.Enroll;

import java.util.List;
import java.util.logging.Logger;

public class EnrollDaoImpl implements EnrollDao {

    private static final Logger LOG = Logger.getLogger(EnrollDaoImpl.class.getName());

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
}
