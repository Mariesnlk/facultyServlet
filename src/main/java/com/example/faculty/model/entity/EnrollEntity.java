package com.example.faculty.model.entity;

import java.util.Date;

public class EnrollEntity {

    public Long enrollId;

    private Date date;

//    public UserEntity student;
//
//    public CourseEntity courseEntity;

    public Long student;

    public Long courseEntity;


    public Long getEnrollId() {
        return enrollId;
    }

    public Date getDate() {
        return date;
    }

    public Long getStudent() {
        return student;
    }

    public Long getCourseEntity() {
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

        public Builder setUser(Long student) {
            newEnrollEntity.student = student;
            return this;
        }

        public Builder setCourse(Long course) {
            newEnrollEntity.courseEntity = course;
            return this;
        }

        public EnrollEntity build() {
            return newEnrollEntity;
        }

    }

}
