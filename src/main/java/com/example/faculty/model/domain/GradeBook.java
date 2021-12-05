package com.example.faculty.model.domain;

import java.util.Date;

public class GradeBook {

    public Long gradeBookId;

    private Date date;

    public Long courseId;

    public Long studentId;

    public int mark;


    public Long getGradeBookId() {
        return gradeBookId;
    }

    public Date getDate() {
        return date;
    }

    public Long getCourseId() {
        return courseId;
    }

    public Long getStudentId() {
        return studentId;
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

        public Builder setDate(Date date) {
            newGradeBook.date = date;
            return this;
        }

        public Builder setCourse(Long course) {
            newGradeBook.courseId = course;
            return this;
        }

        public Builder setStudent(Long student) {
            newGradeBook.studentId = student;
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
