package com.example.faculty.model.domain;

import java.util.Date;

public class GradeBook {

    public Long gradeBookId;

    public long created = new Date().getTime();

    public Course course;

    public User student;

    public int mark;



    public Long getGradeBookId() {
        return gradeBookId;
    }

    public long getCreated() {
        return created;
    }

    public Course getCourse() {
        return course;
    }

    public User getStudent() {
        return student;
    }

    public int getMark() {
        return mark;
    }



    public static class Builder {

        private GradeBook newGradeBook;

        public Builder() {
            newGradeBook = new GradeBook();
        }

        public Builder setGradeBookId(Long gradeBookId) {
            newGradeBook.gradeBookId = gradeBookId;
            return this;
        }

        public Builder setCourse(Course course) {
            newGradeBook.course = course;
            return this;
        }

        public Builder setStudent(User student) {
            newGradeBook.student = student;
            return this;
        }

        public Builder setMark(int mark) {
            newGradeBook.mark = mark;
            return this;
        }

        public GradeBook build() {

            return newGradeBook;
        }

    }
}
