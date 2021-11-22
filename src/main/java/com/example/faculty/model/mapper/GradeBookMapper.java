package com.example.faculty.model.mapper;

import com.example.faculty.model.domain.GradeBook;
import com.example.faculty.model.entity.GradeBookEntity;

public class GradeBookMapper {

    private CourseMapper courseMapper;
    private UserMapper studentMapper;

    public GradeBookMapper(CourseMapper courseMapper, UserMapper teacherMapper) {
        this.courseMapper = courseMapper;
        this.studentMapper = teacherMapper;
    }

    public GradeBook gradeBookEntityToGradeBook(GradeBookEntity gradeBookEntity) {
        if (gradeBookEntity == null) {
            return null;
        }

        return new GradeBook.Builder()
                .setGradeBookId(gradeBookEntity.getGradeBookId())
                .setCourse(courseMapper.courseEntityToCourse(gradeBookEntity.getCourseEntity()))
                .setStudent(studentMapper.userEntityToUser(gradeBookEntity.getStudentEntity()))
                .setMark(gradeBookEntity.getMark())
                .build();

    }

    public GradeBookEntity gradeBookToGradeBookEntity(GradeBook gradeBook) {
        if (gradeBook == null) {
            return null;
        }

        return new GradeBookEntity.Builder()
                .setGradeBookId(gradeBook.getGradeBookId())
                .setCourseEntity(courseMapper.courseToCourseEntity(gradeBook.getCourse()))
                .setStudentEntity(studentMapper.userToUserEntity(gradeBook.getStudent()))
                .setMark(gradeBook.getMark())
                .build();

    }
}
