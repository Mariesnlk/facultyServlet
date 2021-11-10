package com.example.faculty.dao.impl;

import com.example.faculty.dao.interf.TopicDto;
import com.example.faculty.model.entities.Topic;

import java.util.List;
import java.util.logging.Logger;

public class TopicDaoImpl implements TopicDto {

    private static final Logger LOG = Logger.getLogger(TopicDto.class.getName());

    @Override
    public void create(Topic entity) {

    }

    @Override
    public Topic findById(Long id) {
        return null;
    }

    @Override
    public List<Topic> findAll() {
        return null;
    }

    @Override
    public void update(Topic entity) {

    }

    @Override
    public boolean delete(Topic entity) {
        return false;
    }
}
