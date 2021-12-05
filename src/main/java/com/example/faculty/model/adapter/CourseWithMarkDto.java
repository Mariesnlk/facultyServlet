package com.example.faculty.model.adapter;

import com.example.faculty.model.domain.Topic;
import com.example.faculty.model.domain.User;
import com.example.faculty.model.enums.CourseStatus;

public class CourseWithMarkDto {
    private String name;
    private Integer duration;
    private Integer studentsAmount;
    private Topic topic;
    private User student;
    private CourseStatus status;
    private Integer mark;

    public String getName() {
        return name;
    }

    public Integer getDuration() {
        return duration;
    }

    public Integer getStudentsAmount() {
        return studentsAmount;
    }

    public Topic getTopic() {
        return topic;
    }

    public User getStudent() {
        return student;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public Integer getMark() {
        return mark;
    }

    public static class Builder {

        private CourseWithMarkDto courseWithMarkDto;

        public Builder() {
            courseWithMarkDto = new CourseWithMarkDto();
        }

        public Builder setName(String name) {
            courseWithMarkDto.name = name;
            return this;
        }

        public Builder setDuration(Integer duration) {
            courseWithMarkDto.duration = duration;
            return this;
        }

        public Builder setStudentsAmount(Integer studentsAmount) {
            courseWithMarkDto.studentsAmount = studentsAmount;
            return this;
        }

        public Builder setTopic(Topic topic) {
            courseWithMarkDto.topic = topic;
            return this;
        }

        public Builder setStudent(User student) {
            courseWithMarkDto.student = student;
            return this;
        }

        public Builder setStatus(CourseStatus status) {
            courseWithMarkDto.status = status;
            return this;
        }

        public Builder setMark(Integer mark) {
            courseWithMarkDto.mark = mark;
            return this;
        }

        public CourseWithMarkDto build() {

            return courseWithMarkDto;
        }

    }
}
