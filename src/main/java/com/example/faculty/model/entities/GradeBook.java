package com.example.faculty.model.entities;

import com.example.faculty.model.enums.UserRole;

import java.util.Date;

public class GradeBook {

    public Long gradeBookId;

    public long created = new Date().getTime();

    public Long idCourse;

    public Long idStudent;

    public int mark;

    public Long getGradeBookId() {
        return gradeBookId;
    }

    public long getCreated() {
        return created;
    }

    public Long getIdCourse() {
        return idCourse;
    }

    public Long getIdStudent() {
        return idStudent;
    }

    public int getMark() {
        return mark;
    }

    public class Builder {

        public GradeBook.Builder setIdCourse(Long idCourse) {
            GradeBook.this.idCourse = idCourse;
            return this;
        }

        public GradeBook.Builder setIdStudent(Long idStudent) {
            GradeBook.this.idStudent = idStudent;
            return this;
        }

        public GradeBook.Builder setMark(int mark) {
            GradeBook.this.mark = mark;
            return this;
        }

        public GradeBook build() {
            return GradeBook.this;
        }

    }
}
