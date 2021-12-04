package com.example.faculty.model.domain;

import java.util.Date;

public class Enroll {

    public Long enrollId;

    private Date date;

//    public User student;
//
//    public Course course;

    public Long student;

    public Long course;


    public Long getEnrollId() {
        return enrollId;
    }

    public Date getDate() {
        return date;
    }

    public Long getStudent() {
        return student;
    }

    public Long getCourse() {
        return course;
    }

    public static class Builder {

        private Enroll newEnroll;

        public Builder() {
            newEnroll = new Enroll();
        }

        public Builder setEnrollId(Long enrollId) {
            newEnroll.enrollId = enrollId;
            return this;
        }

        public Builder setDate(Date date) {
            newEnroll.date = date;
            return this;
        }

        public Builder setUser(Long student) {
            newEnroll.student = student;
            return this;
        }

        public Builder setCourse(Long course) {
            newEnroll.course = course;
            return this;
        }

        public Enroll build() {
            return newEnroll;
        }

    }

}
