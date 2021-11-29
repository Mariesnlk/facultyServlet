package com.example.faculty.model.adapter;

import com.example.faculty.model.domain.Topic;
import com.example.faculty.model.domain.User;
import com.example.faculty.model.enums.CourseStatus;

public class CourseDto {

    public Long courseId;
    public String courseName;
    public Topic topic;
    public User teacher;
    public int studentsAmount;
    public int enrollStudents;
    public int duration;
    public CourseStatus status;


    public Long getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Topic getTopic() {
        return topic;
    }

    public User getTeacher() {
        return teacher;
    }

    public int getStudentsAmount() {
        return studentsAmount;
    }

    public int getEnrollStudents() {
        return enrollStudents;
    }

    public int getDuration() {
        return duration;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public static class Builder {

        private final CourseDto courseDto;

        public Builder() {
            courseDto = new CourseDto();
        }

        public Builder setCourseId(Long courseId) {
            courseDto.courseId = courseId;
            return this;
        }

        public Builder setTopic(Topic topic) {
            courseDto.topic = topic;
            return this;
        }

        public Builder setTeacher(User teacher) {
            courseDto.teacher = teacher;
            return this;
        }

        public Builder setCourseName(String courseName) {
            courseDto.courseName = courseName;
            return this;
        }

        public Builder setDuration(int duration) {
            courseDto.duration = duration;
            return this;
        }


        public Builder setStudentsAmount(int studentsAmount) {
            courseDto.studentsAmount = studentsAmount;
            return this;
        }

        public Builder setEnrollStudents(int enrollStudents) {
            courseDto.enrollStudents = enrollStudents;
            return this;
        }

        public Builder setCourseStatus(CourseStatus status) {
            courseDto.status = status;
            return this;
        }

        public CourseDto build() {

            return courseDto;
        }

    }
}
