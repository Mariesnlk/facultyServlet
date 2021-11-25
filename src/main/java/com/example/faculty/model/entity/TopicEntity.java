package com.example.faculty.model.entity;

import java.util.Date;
import java.util.Objects;

public class TopicEntity {

    private Date date;

    public Long topicId;

    private String topicName;


    public Date getDate() {
        return date;
    }

    public Long getTopicId() {
        return topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        TopicEntity topicEntity = (TopicEntity) o;
        return Objects.equals(topicName, topicEntity.topicName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topicName);
    }


    public static class Builder {

        private TopicEntity newTopicEntity;

        public Builder() {
            newTopicEntity = new TopicEntity();
        }

        public Builder setDate(Date date) {
            newTopicEntity.date = date;
            return this;
        }

        public Builder setTopicId(Long topicId) {
            newTopicEntity.topicId = topicId;
            return this;
        }

        public Builder setTopicName(String topicName) {
            newTopicEntity.topicName = topicName;
            return this;
        }

        public TopicEntity build() {
            return newTopicEntity;
        }

    }

}
