package com.example.faculty.dao.interf;

import com.example.faculty.model.entity.CourseEntity;
import com.example.faculty.model.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface CourseDao extends CrudDao<CourseEntity, Long> {

    Boolean existsCourseByName(String name);

    long findCountCourses();

    List<CourseEntity> findAllCourses(int row, int limit);

    long findTeachersCountCourses(Long id);

    List<CourseEntity> findTeachersCourses(int row, int limit, Long id);

}
