package com.example.faculty.model.entity;

import java.util.Date;

public class GradeBookEntity {

    public Long gradeBookId;

    public long created = new Date().getTime();

    public CourseEntity courseEntity;

    public UserEntity student;

    public int mark;



    public Long getGradeBookId() {
        return gradeBookId;
    }

    public long getCreated() {
        return created;
    }

    public CourseEntity getCourseEntity() {
        return courseEntity;
    }

    public UserEntity getStudentEntity() {
        return student;
    }

    public int getMark() {
        return mark;
    }



    public static class Builder {

        private GradeBookEntity newGradeBookEntity;

        public Builder() {
            newGradeBookEntity = new GradeBookEntity();
        }

        public Builder setGradeBookId(Long gradeBookId) {
            newGradeBookEntity.gradeBookId = gradeBookId;
            return this;
        }

        public Builder setCourseEntity(CourseEntity courseEntity) {
            newGradeBookEntity.courseEntity = courseEntity;
            return this;
        }

        public Builder setStudentEntity(UserEntity student) {
            newGradeBookEntity.student = student;
            return this;
        }

        public Builder setMark(int mark) {
            newGradeBookEntity.mark = mark;
            return this;
        }

        public GradeBookEntity build() {
            return newGradeBookEntity;
        }

    }
}
