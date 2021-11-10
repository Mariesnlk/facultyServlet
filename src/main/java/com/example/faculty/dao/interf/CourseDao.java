package com.example.faculty.dao.interf;

import com.example.faculty.model.entities.Course;

import java.util.List;

public interface CourseDao extends CrudDao<Course, Long> {

    List<Course> findByName(String name);

    List<Course> findCourseByParams(String courseName, List<Integer> duration, List<Integer> studentsAmount, List<Integer> topic, List<Integer> teacherId, String sortType);

    List<Course> findAllTeachersCourses(int teacherId);

    Course deleteTeacherFromCourse(int courseId);

//    List<StudentCourseInfoDto> findAllStudentCoursesByType(int studentId, String type);

}
