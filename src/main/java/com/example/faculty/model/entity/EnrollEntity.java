package com.example.faculty.model.entity;

import java.util.Date;

public class EnrollEntity {

    public Long enrollId;

    private Date date;

    public UserEntity student;

    public CourseEntity courseEntity;


    public Long getEnrollId() {
        return enrollId;
    }

    public Date getDate() {
        return date;
    }

    public UserEntity getStudentEntity() {
        return student;
    }

    public CourseEntity getCourseEntity() {
        return courseEntity;
    }


    public static class Builder {

        private EnrollEntity newEnrollEntity;

        public Builder() {
            newEnrollEntity = new EnrollEntity();
        }

        public Builder setEnrollId(Long enrollId) {
            newEnrollEntity.enrollId = enrollId;
            return this;
        }

        public Builder setDate(Date date) {
            newEnrollEntity.date = date;
            return this;
        }

        public Builder setUser(UserEntity student) {
            newEnrollEntity.student = student;
            return this;
        }

        public Builder setCourse(CourseEntity course) {
            newEnrollEntity.courseEntity = course;
            return this;
        }

        public EnrollEntity build() {
            return newEnrollEntity;
        }

    }

}
