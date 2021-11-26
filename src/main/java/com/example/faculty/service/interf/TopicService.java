package com.example.faculty.service.interf;

import com.example.faculty.model.domain.Topic;

import java.util.List;

public interface TopicService extends CrudService<Topic, Long> {

    List<Topic> getAllTopics(int row, int limit);

    long getAllTopicsCount();
}
