package com.example.faculty.service.interf;

import com.example.faculty.model.domain.Course;
import com.example.faculty.model.domain.Enroll;
import com.example.faculty.model.domain.User;

public interface EnrollService extends CrudService<Enroll, Long> {

    void enroll(User student, Course course);
}
