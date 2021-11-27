package com.exmple.faculty.model.mapper;

import com.example.faculty.model.domain.Topic;
import com.example.faculty.model.entity.TopicEntity;
import com.example.faculty.model.mapper.TopicMapper;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class TopicMapperTest {

    private static final TopicEntity TOPIC_ENTITY = getTopicEntity();

    private static final Topic TOPIC = getTopic();

    private final TopicMapper topicMapper = new TopicMapper();

    private static TopicEntity getTopicEntity() {

        return new TopicEntity.Builder()
                .setTopicId(1L)
                .setDate(new Date())
                .setTopicName("backend")
                .build();
    }

    private static Topic getTopic() {
        return new Topic.Builder()
                .setTopicId(1L)
                .setDate(new Date())
                .setTopicName("backend")
                .build();
    }

    @Test
    public void shouldMapTopicEntityToTopic() {
        Topic topic = topicMapper.topicEntityToTopic(TOPIC_ENTITY);

        assertThat(topic.getTopicId(), is(TOPIC.getTopicId()));
//        assertThat(topic.getDate(), is(TOPIC.getDate()));
        assertThat(topic.getTopicName(), is(TOPIC.getTopicName()));
    }

    @Test
    public void shouldMapTopicToTopicEntity() {
        TopicEntity topicEntity = topicMapper.topicToTopicEntity(TOPIC);

        assertThat(topicEntity.getTopicId(), is(TOPIC_ENTITY.getTopicId()));
//        assertThat(topicEntity.getDate(), is(TOPIC_ENTITY.getDate()));
        assertThat(topicEntity.getTopicName(), is(TOPIC_ENTITY.getTopicName()));

    }

    @Test
    public void shouldMapTopicToTopicEntityWithoutId() {
        TopicEntity topicEntity = topicMapper.topicToTopicEntityWithoutId(TOPIC);

//        assertThat(topicEntity.getDate(), is(TOPIC_ENTITY.getDate()));
        assertThat(topicEntity.getTopicName(), is(TOPIC_ENTITY.getTopicName()));

    }

    @Test
    public void mapTopicToTopicEntityShouldReturnNull() {
        TopicEntity topicEntity = topicMapper.topicToTopicEntity(null);
        assertThat(topicEntity, is(nullValue()));
    }

    @Test
    public void mapTopicEntityToTopicShouldReturnNull() {
        Topic topic = topicMapper.topicEntityToTopic(null);
        assertThat(topic, is(nullValue()));
    }

    @Test
    public void mapTopicToTopicEntityWithoutIdShouldReturnNull() {
        TopicEntity topicEntity = topicMapper.topicToTopicEntityWithoutId(null);
        assertThat(topicEntity, is(nullValue()));
    }
}
