package com.example.faculty.model.entity;

import java.util.Date;

public class GradeBookEntity {

    public Long gradeBookId;

    private Date date;

    public Long courseEntity;

    public Long student;

    public int mark;


    public Long getGradeBookId() {
        return gradeBookId;
    }

    public Date getDate() {
        return date;
    }

    public Long getCourseEntity() {
        return courseEntity;
    }

    public Long getStudentEntity() {
        return student;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
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

        public Builder setDate(Date date) {
            newGradeBookEntity.date = date;
            return this;
        }

        public Builder setCourseEntity(Long courseEntity) {
            newGradeBookEntity.courseEntity = courseEntity;
            return this;
        }

        public Builder setStudentEntity(Long student) {
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
