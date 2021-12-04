package com.example.faculty.service.interf;

import com.example.faculty.model.domain.Course;
import com.example.faculty.model.domain.Topic;

import java.util.List;

public interface CourseService extends CrudService<Course, Long> {

    List<Course> getAllCourses(int row, int limit);

    long getAllCoursesCount();

    void increaseCountOfEnrollStudents(Long courseId);

//    Paged getCoursesPage(String courseName, Integer duration, Integer studentsAmount, String topic,
//                         String teacher, String status, int pageNumber, int size, String sortType);
//
//    Paged getStudentCoursesPage(String courseName, Integer duration, Integer studentsAmount, String topic,
//                                String teacher, String courseStatus, Long studentId, int pageNumber, int size, String sortType);

//    Page<Course> findAllCourses(Pageable pageable);

//    Page<Course> findAllStudentCourses(Long studentId, Pageable pageable);

    List<String> findAllCourseNames();

    List<Integer> findAllDurations();

    List<Integer> findAllStudentsAmount();

    List<String> findCourseNameByName(String name);

    List<String> findAllTopics();

    List<Integer> findAllTeacherNames();

    List<Integer> findTeacherIdByName(String name);

//    Paged findAllCoursesByTeacher(User teacherId, int pageNumber, int size);

}
