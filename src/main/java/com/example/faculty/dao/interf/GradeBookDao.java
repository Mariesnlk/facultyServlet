package com.example.faculty.dao.interf;

import com.example.faculty.model.entity.CourseEntity;
import com.example.faculty.model.entity.GradeBookEntity;
import com.example.faculty.model.entity.UserEntity;

public interface GradeBookDao extends CrudDao<GradeBookEntity, Long> {

    Boolean existsGradeBookByCourseAndStudent(CourseEntity courseEntity, UserEntity student);

    GradeBookEntity findGradeBookByCourseAndStudent(CourseEntity courseEntity, UserEntity student);
}
