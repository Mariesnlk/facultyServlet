package com.example.faculty.dao.interf;

import com.example.faculty.model.domain.CoursesWithMyMark;

import java.util.List;

public interface CourseWithMyMarkDao {

    List<CoursesWithMyMark> findAllStudentCourses(Long studentId);
}
