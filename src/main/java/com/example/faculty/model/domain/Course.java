package com.example.faculty.model.domain;

import com.example.faculty.model.enums.CourseStatus;

import java.util.Date;
import java.util.Objects;

public class Course {

    public Long courseId;

    private Date date;

    public Topic topic;

    public User teacher;

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

    public Topic getTopic() {
        return topic;
    }

    public User getTeacher() {
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

        public Builder setTopic(Topic topic) {
            newCourse.topic = topic;
            return this;
        }

        public Builder setTeacher(User teacher) {
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
