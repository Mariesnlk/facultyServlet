package com.example.faculty.service.impl;

import com.example.faculty.dao.interf.GradeBookDao;
import com.example.faculty.model.domain.GradeBook;
import com.example.faculty.model.entity.GradeBookEntity;
import com.example.faculty.model.mapper.GradeBookMapper;
import com.example.faculty.service.interf.GradeBookService;
import org.apache.log4j.Logger;

import java.util.Date;

public class GradeBookServiceImpl implements GradeBookService {

    private static final Logger LOGGER = Logger.getLogger(GradeBookServiceImpl.class);

    private GradeBookDao gradeBookDao;
    private GradeBookMapper gradeBookMapper;

    public GradeBookServiceImpl(GradeBookDao gradeBookDao, GradeBookMapper gradeBookMapper) {
        this.gradeBookDao = gradeBookDao;
        this.gradeBookMapper = gradeBookMapper;
    }

    @Override
    public void saveMark(Long student, Long course, Integer mark) {
        if (!gradeBookDao.existsGradeBookByCourseAndStudent(course, student))
            gradeBookDao.create(gradeBookMapper.gradeBookToGradeBookEntity(
                    new GradeBook.Builder()
                            .setDate(new Date())
                            .setCourse(course)
                            .setStudent(student)
                            .setMark(mark)
                            .build()));
        else {
            GradeBookEntity gradeBook = gradeBookDao.findGradeBookByCourseAndStudent(course, student);
            gradeBook.setMark(mark);
            gradeBookDao.update(gradeBook);
        }
    }
}
