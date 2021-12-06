package com.example.faculty.service.impl;

import com.example.faculty.dao.interf.TopicDao;
import com.example.faculty.exception.EmailIsAlreadyTaken;
import com.example.faculty.exception.InputDataInCorrectRuntimeException;
import com.example.faculty.exception.NameIsAlreadyTaken;
import com.example.faculty.model.domain.Topic;
import com.example.faculty.model.entity.TopicEntity;
import com.example.faculty.model.mapper.TopicMapper;
import com.example.faculty.service.interf.TopicService;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
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
    public void create(Topic topic) {
        if (Objects.isNull(topic)) {
            LOGGER.warn("creating TopicServiceImpl create topic in database");
            throw new InputDataInCorrectRuntimeException("Topic is empty");
        }
        boolean isTakenName = topicDao.existsTopicByName(topic.getTopicName());
        if (isTakenName) {
            LOGGER.warn("name is taken, exception occurred");
            throw new NameIsAlreadyTaken("This name is already used");
        }
        topicDao.create(topicMapper.topicToTopicEntity(topic));
    }

    @Override
    public Topic findById(Long id) {
        if (Objects.isNull(id)) {
            LOGGER.warn("find topic by id");
            throw new InputDataInCorrectRuntimeException("Topic must be not null");
        }
        TopicEntity topicEntity = topicDao.findById(id);
        return topicMapper.topicEntityToTopic(topicEntity);
    }

    @Override
    public List<Topic> findAll() {
        List<TopicEntity> topicEntities = topicDao.findAll();
        return topicEntities.isEmpty() ?
                Collections.emptyList() : topicEntities.stream()
                .map(topicMapper::topicEntityToTopic)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Topic topic) {
        if (Objects.isNull(topic)) {
            LOGGER.warn("creating TopicServiceImpl updateTopic");
            throw new InputDataInCorrectRuntimeException("Topic must be not null");
        }
        topicDao.update(topicMapper.topicToTopicEntity(topic));
    }

    @Override
    public boolean delete(Topic topic) {
        if (Objects.isNull(topic)) {
            LOGGER.warn("creating TopicServiceImpl deleteTopic");
            throw new InputDataInCorrectRuntimeException("Topic must be not null");
        }
        return topicDao.delete(topicMapper.topicToTopicEntity(topic));
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
    public List<Topic> getAllTopics() {
        List<TopicEntity> topicEntities = topicDao.findAll();
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
