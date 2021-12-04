package com.example.faculty.model.mapper;

import com.example.faculty.model.domain.Enroll;
import com.example.faculty.model.entity.EnrollEntity;

public class EnrollMapper {

    private CourseMapper courseMapper;
    private UserMapper studentMapper;

    public EnrollMapper(CourseMapper courseMapper, UserMapper teacherMapper) {
        this.courseMapper = courseMapper;
        this.studentMapper = teacherMapper;
    }

    public Enroll enrollEntityToEnroll(EnrollEntity enrollEntity) {
        if (enrollEntity == null) {
            return null;
        }

        return new Enroll.Builder()
                .setEnrollId(enrollEntity.getEnrollId())
                .setDate(enrollEntity.getDate())
//                .setCourse(courseMapper.courseEntityToCourse(enrollEntity.getCourseEntity()))
//                .setUser(studentMapper.userEntityToUser(enrollEntity.getStudentEntity()))
                .setCourse(enrollEntity.getCourseEntity())
                .setUser(enrollEntity.getStudent())
                .build();

    }

    public EnrollEntity enrollToEnrollEntity(Enroll enroll) {
        if (enroll == null) {
            return null;
        }

        return new EnrollEntity.Builder()
                .setEnrollId(enroll.getEnrollId())
                .setDate(enroll.getDate())
//                .setCourse(courseMapper.courseToCourseEntity(enroll.getCourse()))
//                .setUser(studentMapper.userToUserEntity(enroll.getStudent()))
                .setCourse(enroll.getCourse())
                .setUser(enroll.getStudent())
                .build();

    }
}
