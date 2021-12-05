package com.example.faculty.model.domain;

import com.example.faculty.model.enums.CourseStatus;

public class CoursesWithMyMark {
    private String name;
    private Integer duration;
    private Integer studentsAmount;
    private Long topicId;
    private Long teacherId;
    private CourseStatus status;
    private Integer mark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getStudentsAmount() {
        return studentsAmount;
    }

    public void setStudentsAmount(Integer studentsAmount) {
        this.studentsAmount = studentsAmount;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public CoursesWithMyMark(String name, Integer duration, Integer studentsAmount, Long topicId, Long teacherId,
                             CourseStatus status, Integer mark) {
        this.name = name;
        this.duration = duration;
        this.studentsAmount = studentsAmount;
        this.topicId = topicId;
        this.teacherId = teacherId;
        this.status = status;
        this.mark = mark;
    }

    public CoursesWithMyMark() {
    }

    public static class Builder {

        private CoursesWithMyMark coursesWithMyMark;

        public Builder() {
            coursesWithMyMark = new CoursesWithMyMark();
        }

        public Builder setName(String name) {
            coursesWithMyMark.name = name;
            return this;
        }

        public Builder setDuration(Integer duration) {
            coursesWithMyMark.duration = duration;
            return this;
        }

        public Builder setStudentsAmount(Integer studentsAmount) {
            coursesWithMyMark.studentsAmount = studentsAmount;
            return this;
        }

        public Builder setTopicId(Long topic) {
            coursesWithMyMark.topicId = topic;
            return this;
        }

        public Builder setTeacherId(Long teacher) {
            coursesWithMyMark.teacherId = teacher;
            return this;
        }

        public Builder setStatus(CourseStatus status) {
            coursesWithMyMark.status = status;
            return this;
        }

        public Builder setMark(Integer mark) {
            coursesWithMyMark.mark = mark;
            return this;
        }

        public CoursesWithMyMark build() {

            return coursesWithMyMark;
        }

    }

}
