package com.example.faculty.dao.interf;

import com.example.faculty.model.entity.CourseEntity;
import com.example.faculty.model.entity.EnrollEntity;
import com.example.faculty.model.entity.UserEntity;

public interface EnrollDao extends CrudDao<EnrollEntity, Long> {

    Boolean existsEnrollByCourseAndUser(CourseEntity courseEntity, UserEntity userEntity);

    void deleteByCourseAndUser(CourseEntity courseEntity, UserEntity userEntity);
}
