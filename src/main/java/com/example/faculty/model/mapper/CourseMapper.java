package com.example.faculty.model.mapper;

import com.example.faculty.model.domain.Course;
import com.example.faculty.model.entity.CourseEntity;

public class CourseMapper {

    private TopicMapper topicMapper;
    private UserMapper teacherMapper;

    public CourseMapper(TopicMapper topicMapper, UserMapper teacherMapper) {
        this.topicMapper = topicMapper;
        this.teacherMapper = teacherMapper;
    }

    public Course courseEntityToCourse(CourseEntity courseEntity) {
        if (courseEntity == null) {
            return null;
        }

        return new Course.Builder()
                .setCourseId(courseEntity.getCourseId())
                .setCourseName(courseEntity.getCourseName())
                .setTopic(topicMapper.topicEntityToTopic(courseEntity.getTopicEntity()))
                .setDuration(courseEntity.getDuration())
                .setTeacher(teacherMapper.userEntityToUser(courseEntity.getTeacherEntity()))
                .setStudentsAmount(courseEntity.getStudentsAmount())
                .setEnrollStudents(courseEntity.getEnrollStudents())
                .setCourseStatus(courseEntity.getStatus())
                .build();

    }

    public CourseEntity courseToCourseEntity(Course course) {
        if (course == null) {
            return null;
        }

        return new CourseEntity.Builder()
                .setCourseId(course.getCourseId())
                .setCourseName(course.getCourseName())
                .setTopic(topicMapper.topicToTopicEntity(course.getTopic()))
                .setTeacher(teacherMapper.userToUserEntity(course.getTeacher()))
                .setDuration(course.getDuration())
                .setStudentsAmount(course.getStudentsAmount())
                .setEnrollStudents(course.getEnrollStudents())
                .setCourseStatus(course.getStatus())
                .build();

    }
}
