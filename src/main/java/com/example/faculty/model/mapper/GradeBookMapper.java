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
                .setDate(gradeBookEntity.getDate())
                .setCourse(gradeBookEntity.getCourseEntity())
                .setStudent(gradeBookEntity.getStudentEntity())
                .setMark(gradeBookEntity.getMark())
                .build();

    }

    public GradeBookEntity gradeBookToGradeBookEntity(GradeBook gradeBook) {
        if (gradeBook == null) {
            return null;
        }

        return new GradeBookEntity.Builder()
                .setGradeBookId(gradeBook.getGradeBookId())
                .setDate(gradeBook.getDate())
                .setCourseEntity(gradeBook.getCourseId())
                .setStudentEntity(gradeBook.getStudentId())
                .setMark(gradeBook.getMark())
                .build();

    }
}
