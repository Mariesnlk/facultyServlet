package com.example.faculty.model.entities;

import com.example.faculty.model.enums.CourseStatus;

import java.util.Date;
import java.util.Objects;

public class Course {

    public Long courseId;

    public long created = new Date().getTime();

    public Long idTopic;

    public Long idTeacher;

    public String courseName;

    public int duration;

    public int studentsAmount;

    public CourseStatus status;

    public Long getCourseId() {
        return courseId;
    }

    public long getCreated() {
        return created;
    }

    public Long getIdTopic() {
        return idTopic;
    }

    public Long getIdTeacher() {
        return idTeacher;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getDuration() {
        return duration;
    }

    public int getStudentsAmount() {
        return studentsAmount;
    }

    public CourseStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Course course = (Course) o;
        return Objects.equals(courseName, course.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName);
    }


    public class Builder {

        public Course.Builder setIdTopic(Long idTopic) {
            Course.this.idTopic = idTopic;
            return this;
        }

        public Course.Builder setIdTeacher(Long idTeacher) {
            Course.this.idTeacher = idTeacher;
            return this;
        }

        public Course.Builder setCourseName(String courseName) {
            Course.this.courseName = courseName;
            return this;
        }

        public Course.Builder setDuration(int duration) {
            Course.this.duration = duration;
            return this;
        }


        public Course.Builder setStudentsAmount(int studentsAmount) {
            Course.this.studentsAmount = studentsAmount;
            return this;
        }

        public Course.Builder setCourseStatus(CourseStatus status) {
            Course.this.status = status;
            return this;
        }

        public Course build() {
            return Course.this;
        }

    }
}
