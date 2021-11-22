package com.example.faculty.dao.impl;

import com.example.faculty.dao.interf.TopicDto;
import com.example.faculty.model.entity.TopicEntity;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class TopicDaoImpl implements TopicDto {

    private static final Logger LOG = Logger.getLogger(TopicDto.class.getName());

    @Override
    public void create(TopicEntity entity) {

    }

    @Override
    public TopicEntity findById(Long id) {
        return null;
    }

    @Override
    public List<TopicEntity> findAll() {
        return null;
    }

    @Override
    public void update(TopicEntity entity) {

    }

    @Override
    public boolean delete(TopicEntity entity) {
        return false;
    }

    @Override
    public Optional<TopicEntity> findTopicById(Long topicId) {
        return Optional.empty();
    }

    @Override
    public Boolean existsTopicByName(String topicName) {
        return null;
    }

    @Override
    public List<TopicEntity> findByOrderByCreatedDate() {
        return null;
    }
}
