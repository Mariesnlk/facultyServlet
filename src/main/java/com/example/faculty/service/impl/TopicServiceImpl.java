package com.example.faculty.service.impl;

import com.example.faculty.dao.interf.TopicDao;
import com.example.faculty.exception.InputDataInCorrectRuntimeException;
import com.example.faculty.model.domain.Topic;
import com.example.faculty.model.entity.TopicEntity;
import com.example.faculty.model.mapper.TopicMapper;
import com.example.faculty.service.interf.TopicService;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TopicServiceImpl implements TopicService {

    private static final Logger LOGGER = Logger.getLogger(TopicServiceImpl.class);
    private TopicDao topicDao;
    private TopicMapper topicMapper;

    public TopicServiceImpl(TopicDao topicDao, TopicMapper topicMapper) {
        this.topicDao = topicDao;
        this.topicMapper = topicMapper;
    }

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

    @Override
    public List<Topic> getAllTopics(int row, int limit) {
        if (row < 0 || limit < 0) {
            LOGGER.warn("TopicServiceImpl getAllTopics");
            throw new InputDataInCorrectRuntimeException("row,limit must be positive");
        }
        List<TopicEntity> topicEntities = topicDao.findAllTopics(row, limit);

        return topicEntities.isEmpty() ?
                Collections.emptyList() : topicEntities.stream()
                .map(topicMapper::topicEntityToTopic)
                .collect(Collectors.toList());
    }

    @Override
    public long getAllTopicsCount() {
        return topicDao.findCountTopics();
    }
}
