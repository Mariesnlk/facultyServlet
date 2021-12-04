package com.example.faculty.service.impl;

import com.example.faculty.dao.interf.EnrollDao;
import com.example.faculty.model.domain.Enroll;
import com.example.faculty.model.mapper.EnrollMapper;
import com.example.faculty.service.interf.EnrollService;
import org.apache.log4j.Logger;

import java.util.Date;

public class EnrollServiceImpl implements EnrollService {

    private static final Logger LOGGER = Logger.getLogger(EnrollServiceImpl.class);

    private EnrollDao enrollDao;
    private EnrollMapper enrollMapper;

    public EnrollServiceImpl(EnrollDao enrollDao, EnrollMapper enrollMapper) {
        this.enrollDao = enrollDao;
        this.enrollMapper = enrollMapper;
    }

    @Override
    public boolean enroll(Long studentId, Long courseId) {
        if (!enrollDao.existsEnrollByCourseAndUser(courseId, studentId)) {

            LOGGER.info("EnrollServiceImpl start enroll ");
            enrollDao.create(enrollMapper.enrollToEnrollEntity(
                    new Enroll.Builder()
                            .setDate(new Date())
                            .setCourse(courseId)
                            .setUser(studentId)
                            .build()));
            LOGGER.info("EnrollServiceImpl end enroll ");
            return true;
        }
        return false;
    }
}
