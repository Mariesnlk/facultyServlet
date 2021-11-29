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
                .setDate(courseEntity.getDate())
                .setCourseName(courseEntity.getCourseName())
//                .setTopic(topicMapper.topicEntityToTopic(courseEntity.getTopicEntity()))
                .setTopic(courseEntity.getTopic())
                .setDuration(courseEntity.getDuration())
                //.setTeacher(teacherMapper.userEntityToUser(courseEntity.getTeacherEntity()))
                .setTeacher(courseEntity.getTeacher())
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
                .setDate(course.getDate())
                .setCourseName(course.getCourseName())
//                .setTopic(topicMapper.topicToTopicEntity(course.getTopic()))
//                .setTeacher(teacherMapper.userToUserEntity(course.getTeacher()))
                .setTopic(course.getTopic())
                .setTeacher(course.getTeacher())
                .setDuration(course.getDuration())
                .setStudentsAmount(course.getStudentsAmount())
                .setEnrollStudents(course.getEnrollStudents())
                .setCourseStatus(course.getStatus())
                .build();

    }
}
