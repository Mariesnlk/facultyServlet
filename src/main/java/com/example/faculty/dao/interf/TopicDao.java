package com.example.faculty.dao.interf;

import com.example.faculty.model.entity.TopicEntity;

import java.util.List;
import java.util.Optional;

public interface TopicDao extends CrudDao<TopicEntity, Long> {

    Boolean existsTopicByName(String topicName);

    List<TopicEntity> findByOrderByCreatedDate();

    long findCountTopics();

    List<TopicEntity> findAllTopics(int row, int limit);

}
