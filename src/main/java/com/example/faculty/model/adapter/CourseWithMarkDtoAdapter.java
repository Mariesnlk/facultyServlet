package com.example.faculty.model.adapter;

import com.example.faculty.model.domain.CoursesWithMyMark;
import com.example.faculty.service.interf.TopicService;
import com.example.faculty.service.interf.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class CourseWithMarkDtoAdapter {
    private TopicService topicService;
    private UserService userService;

    public CourseWithMarkDtoAdapter(TopicService topicService, UserService userService) {
        this.topicService = topicService;
        this.userService = userService;
    }

    public List<CourseWithMarkDto> coursesListAdapter(List<CoursesWithMyMark> courses) {
        return courses.stream().map(this::adapterCourse).collect(Collectors.toList());
    }

    public CourseWithMarkDto adapterCourse(CoursesWithMyMark course) {
        return new CourseWithMarkDto.Builder()
                .setName(course.getName())
                .setTopic(topicService.findById(course.getTopicId()))
                .setStudent(userService.findById(course.getTeacherId()))
                .setDuration(course.getDuration())
                .setStudentsAmount(course.getStudentsAmount())
                .setStatus(course.getStatus())
                .setMark(course.getMark())
                .build();
    }
}
