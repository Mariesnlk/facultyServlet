package com.example.faculty.dao.impl;

import com.example.faculty.dao.interf.GradeBookDto;
import com.example.faculty.model.entities.GradeBook;

import java.util.List;
import java.util.logging.Logger;

public class GradeBookDaoImpl implements GradeBookDto {

    private static final Logger LOG = Logger.getLogger(GradeBookDaoImpl.class.getName());

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
}
