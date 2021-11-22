package com.example.faculty.model.entity;

import java.util.Objects;

public class TopicEntity {

    public Long topicId;

    private String topicName;



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
