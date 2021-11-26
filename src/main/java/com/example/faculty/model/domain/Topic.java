package com.example.faculty.model.domain;

import java.util.Date;
import java.util.Objects;

public class Topic {

    public Long topicId;

    private String topicName;

    private Date date;


    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getTopicId() {
        return topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Topic topic = (Topic) o;
        return Objects.equals(topicName, topic.topicName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topicName);
    }



    public static class Builder {

        private Topic newTopic;

        public Builder() {
            newTopic = new Topic();
        }

        public Builder setTopicId(Long topicId) {
            newTopic.topicId = topicId;
            return this;
        }

        public Builder setDate(Date date) {
            newTopic.date = date;
            return this;
        }

        public Builder setTopicName(String topicName) {
            newTopic.topicName = topicName;
            return this;
        }

        public Topic build() {
            return newTopic;
        }

    }

}
