package com.example.faculty.service.interf;

import com.example.faculty.model.domain.Course;
import com.example.faculty.model.domain.GradeBook;
import com.example.faculty.model.domain.User;

public interface GradeBookService extends CrudService<GradeBook, Long> {

    void saveMark(User student, Course course, Integer mark);
}
