package com.example.faculty.dao.interf;

import com.example.faculty.model.domain.StudentMark;

import java.util.List;

public interface StudentMarkDao {

    List<StudentMark> findAllStudentsMark(Long courseId);
}
