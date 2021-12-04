package com.example.faculty.model.entity;

import com.example.faculty.model.enums.CourseStatus;

import java.util.Date;
import java.util.Objects;

public class CourseEntity {

    public Long courseId;

    private Date date;

//    public TopicEntity topic;
//
//    public UserEntity teacher;

    public Long topic;

    public Long teacher;

    public String courseName;

    public int duration;

    public int studentsAmount;

    public int enrollStudents;

    public CourseStatus status;


    public Long getCourseId() {
        return courseId;
    }

    public Date getDate() {
        return date;
    }

//    public TopicEntity getTopicEntity() {
//        return topic;
//    }
//
//    public UserEntity getTeacherEntity() {
//        return teacher;
//    }


    public Long getTopic() {
        return topic;
    }

    public Long getTeacher() {
        return teacher;
    }

    public int getEnrollStudents() {
        return enrollStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getDuration() {
        return duration;
    }

    public int getStudentsAmount() {
        return studentsAmount;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setEnrollStudents(int enrollStudents) {
        this.enrollStudents = enrollStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        CourseEntity courseEntity = (CourseEntity) o;
        return Objects.equals(courseName, courseEntity.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName);
    }


    public static class Builder {

        private CourseEntity courseEntity;

        public Builder() {
            courseEntity = new CourseEntity();
        }

        public Builder setCourseId(Long courseId) {
            courseEntity.courseId = courseId;
            return this;
        }

        public Builder setDate(Date date) {
            courseEntity.date = date;
            return this;
        }

        public Builder setTopic(Long topic) {
            courseEntity.topic = topic;
            return this;
        }

        public Builder setTeacher(Long teacher) {
            courseEntity.teacher = teacher;
            return this;
        }

        public Builder setCourseName(String courseName) {
            courseEntity.courseName = courseName;
            return this;
        }

        public Builder setDuration(int duration) {
            courseEntity.duration = duration;
            return this;
        }

        public Builder setStudentsAmount(int studentsAmount) {
            courseEntity.studentsAmount = studentsAmount;
            return this;
        }

        public Builder setEnrollStudents(int enrollStudents) {
            courseEntity.enrollStudents = enrollStudents;
            return this;
        }

        public Builder setCourseStatus(CourseStatus status) {
            courseEntity.status = status;
            return this;
        }

        public CourseEntity build() {

            return courseEntity;
        }

    }
}
