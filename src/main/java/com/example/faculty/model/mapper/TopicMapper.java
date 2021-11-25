package com.example.faculty.model.mapper;

import com.example.faculty.model.domain.Topic;
import com.example.faculty.model.entity.TopicEntity;

public class TopicMapper {

    public Topic topicEntityToTopic(TopicEntity topicEntity) {
        if (topicEntity == null) {
            return null;
        }

        return new Topic.Builder()
                .setTopicId(topicEntity.getTopicId())
                .setTopicName(topicEntity.getTopicName())
                .build();
    }

    public TopicEntity topicToTopicEntity(Topic topic) {
        if (topic == null) {
            return null;
        }

        return new TopicEntity.Builder()
                .setDate(topic.getDate())
                .setTopicId(topic.getTopicId())
                .setTopicName(topic.getTopicName())
                .build();
    }

    public TopicEntity topicToTopicEntityWithoutId(Topic topic) {
        if (topic == null) {
            return null;
        }

        return new TopicEntity.Builder()
                .setDate(topic.getDate())
                .setTopicName(topic.getTopicName())
                .build();
    }
}
