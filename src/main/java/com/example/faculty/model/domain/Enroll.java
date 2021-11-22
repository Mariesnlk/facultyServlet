package com.example.faculty.model.domain;

import java.util.Date;

public class Enroll {

    public Long enrollId;

    public long created = new Date().getTime();

    public User student;

    public Course course;



    public Long getEnrollId() {
        return enrollId;
    }

    public long getCreated() {
        return created;
    }

    public User getStudent() {
        return student;
    }

    public Course getCourse() {
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

        public Builder setUser(User student) {
            newEnroll.student = student;
            return this;
        }

        public Builder setCourse(Course course) {
            newEnroll.course = course;
            return this;
        }

        public Enroll build() {
            return newEnroll;
        }

    }

}
