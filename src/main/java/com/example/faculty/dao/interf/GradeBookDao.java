package com.example.faculty.dao.interf;

import com.example.faculty.model.entity.GradeBookEntity;

public interface GradeBookDao extends CrudDao<GradeBookEntity, Long> {

    Boolean existsGradeBookByCourseAndStudent(Long course, Long student);

    GradeBookEntity findGradeBookByCourseAndStudent(Long course, Long student);
}
