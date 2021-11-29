package com.example.faculty.model.domain;

import com.example.faculty.model.enums.CourseStatus;

import java.util.Date;
import java.util.Objects;

public class Course {

    public Long courseId;

    private Date date;

    public Long topic;

    public Long teacher;

    public String courseName;

    public int duration;

    public int studentsAmount;

    public int enrollStudents;

    public CourseStatus status;


    public Long getCourseId() {
        return courseId;
    }

    public Date getDate() {
        return date;
    }

    public Long getTopic() {
        return topic;
    }

    public Long getTeacher() {
        return teacher;
    }

    public int getEnrollStudents() {
        return enrollStudents;
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


    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTopic(Long topic) {
        this.topic = topic;
    }

    public void setTeacher(Long teacher) {
        this.teacher = teacher;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setStudentsAmount(int studentsAmount) {
        this.studentsAmount = studentsAmount;
    }

    public void setEnrollStudents(int enrollStudents) {
        this.enrollStudents = enrollStudents;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
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


    public static class Builder {

        private Course newCourse;

        public Builder() {
            newCourse = new Course();
        }

        public Builder setCourseId(Long courseId) {
            newCourse.courseId = courseId;
            return this;
        }

        public Builder setDate(Date date) {
            newCourse.date = date;
            return this;
        }

        public Builder setTopic(Long topic) {
            newCourse.topic = topic;
            return this;
        }

        public Builder setTeacher(Long teacher) {
            newCourse.teacher = teacher;
            return this;
        }

        public Builder setCourseName(String courseName) {
            newCourse.courseName = courseName;
            return this;
        }

        public Builder setDuration(int duration) {
            newCourse.duration = duration;
            return this;
        }


        public Builder setStudentsAmount(int studentsAmount) {
            newCourse.studentsAmount = studentsAmount;
            return this;
        }

        public Builder setEnrollStudents(int enrollStudents) {
            newCourse.enrollStudents = enrollStudents;
            return this;
        }

        public Builder setCourseStatus(CourseStatus status) {
            newCourse.status = status;
            return this;
        }

        public Course build() {

            return newCourse;
        }

    }
}
