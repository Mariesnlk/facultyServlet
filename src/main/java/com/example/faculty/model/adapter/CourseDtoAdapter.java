package com.example.faculty.model.adapter;

import com.example.faculty.model.domain.Course;
import com.example.faculty.service.interf.TopicService;
import com.example.faculty.service.interf.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class CourseDtoAdapter {

    private TopicService topicService;
    private UserService userService;

    public CourseDtoAdapter(TopicService topicService, UserService userService) {
        this.topicService = topicService;
        this.userService = userService;
    }

    public List<CourseDto> coursesListAdapter(List<Course> courses) {
        return courses.stream().map(this::adapterCourse).collect(Collectors.toList());
    }

    public CourseDto adapterCourse(Course course) {
        return new CourseDto.Builder()
                .setCourseId(course.getCourseId())
                .setTopic(topicService.findById(course.getTopic()))
                .setTeacher(userService.findById(course.getTeacher()))
                .setCourseName(course.getCourseName())
                .setDuration(course.getDuration())
                .setStudentsAmount(course.getStudentsAmount())
                .setEnrollStudents(course.getEnrollStudents())
                .setCourseStatus(course.getStatus())
                .build();
    }
}
