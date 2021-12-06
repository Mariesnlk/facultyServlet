package com.exmple.faculty.model.service.impl;

import com.example.faculty.dao.interf.TopicDao;
import com.example.faculty.exception.InputDataInCorrectRuntimeException;
import com.example.faculty.exception.NameIsAlreadyTaken;
import com.example.faculty.model.domain.Topic;
import com.example.faculty.model.entity.TopicEntity;
import com.example.faculty.model.mapper.TopicMapper;
import com.example.faculty.service.impl.TopicServiceImpl;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TopicServiceImplTest {

    private static final TopicEntity TOPIC_ENTITY = getTopicEntity();
    private static final Topic TOPIC = getTopic();
    private static final List<TopicEntity> TOPIC_ENTITIES = Arrays.asList(TOPIC_ENTITY, TOPIC_ENTITY);
    private static final List<Topic> TOPICS = Arrays.asList(TOPIC, TOPIC);

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Mock
    private TopicDao dao;

    @Mock
    private TopicMapper mapper;

    @After
    public void resetMock() {
        reset(dao, mapper);
    }

    @InjectMocks
    private TopicServiceImpl service;


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
    public void createTopicInDatabaseShouldReturnTopic() {
        when(dao.existsTopicByName(anyString())).thenReturn(false);
        when(mapper.topicToTopicEntity(any(Topic.class))).thenReturn(TOPIC_ENTITY);

        service.create(TOPIC);

        verify(dao).create(any(TopicEntity.class));
    }

    @Test
    public void createTopicInDatabaseShouldThrowNameIsAlreadyTaken() {
        when(dao.existsTopicByName(anyString())).thenReturn(true);
        exception.expect(NameIsAlreadyTaken.class);
        exception.expectMessage("This name is already used");

        service.create(TOPIC);
    }

    @Test
    public void createTopicInDatabaseShouldThrowInvalidDataRuntimeExceptionWithEmptyParams() {
        exception.expect(InputDataInCorrectRuntimeException.class);
        exception.expectMessage("Topic is empty");

        service.create(null);
    }

    @Test
    public void getAllTopicsShouldReturnListOfTopics() {
        when(dao.findAllTopics(anyInt(), anyInt())).thenReturn(TOPIC_ENTITIES);
        when(mapper.topicEntityToTopic(any(TopicEntity.class))).thenReturn(TOPIC);

        List<Topic> actual = service.getAllTopics(1, 1);

        assertThat(actual, is(TOPICS));
    }

}
