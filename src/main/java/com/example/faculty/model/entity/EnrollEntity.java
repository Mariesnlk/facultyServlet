package com.example.faculty.model.entity;

import java.util.Date;

public class EnrollEntity {

    public Long enrollId;

    public long created = new Date().getTime();

    public UserEntity student;

    public CourseEntity courseEntity;



    public Long getEnrollId() {
        return enrollId;
    }

    public long getCreated() {
        return created;
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
