package com.example.faculty.dao.interf;

import com.example.faculty.model.entity.TopicEntity;

import java.util.List;
import java.util.Optional;

public interface TopicDao extends CrudDao<TopicEntity, Long> {

    Optional<TopicEntity> findTopicById(Long topicId);

    Boolean existsTopicByName(String topicName);

    List<TopicEntity> findByOrderByCreatedDate();

//    Page<Topic> findAllByOrderByCreatedDateDesc(Pageable pageable);
}
