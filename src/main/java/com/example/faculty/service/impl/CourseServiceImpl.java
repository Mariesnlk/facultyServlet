package com.example.faculty.service.impl;

import com.example.faculty.dao.interf.CourseDao;
import com.example.faculty.dao.interf.TopicDao;
import com.example.faculty.dao.interf.UserDao;
import com.example.faculty.exception.InputDataInCorrectRuntimeException;
import com.example.faculty.model.domain.Course;
import com.example.faculty.model.entity.CourseEntity;
import com.example.faculty.model.entity.TopicEntity;
import com.example.faculty.model.mapper.CourseMapper;
import com.example.faculty.model.mapper.TopicMapper;
import com.example.faculty.model.mapper.UserMapper;
import com.example.faculty.service.interf.CourseService;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CourseServiceImpl implements CourseService {

    private static final Logger LOGGER = Logger.getLogger(CourseServiceImpl.class);

    private CourseDao courseDao;
    private CourseMapper courseMapper;

    public CourseServiceImpl(CourseDao courseDao, CourseMapper courseMapper) {
        this.courseDao = courseDao;
        this.courseMapper = courseMapper;
    }

    @Override
    public void create(Course course) {
        courseDao.create(courseMapper.courseToCourseEntity(course));

    }

    @Override
    public Course findById(Long id) {
        if (Objects.isNull(id)) {
            LOGGER.warn("find course by id");
            throw new InputDataInCorrectRuntimeException("Course must be not null");
        }
        CourseEntity courseEntity = courseDao.findById(id);
        return courseMapper.courseEntityToCourse(courseEntity);
    }

    @Override
    public List<Course> findAll() {
        List<CourseEntity> courseEntities = courseDao.findAll();
        return courseEntities.isEmpty() ?
                Collections.emptyList() : courseEntities.stream()
                .map(courseMapper::courseEntityToCourse)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Course course) {
        if (Objects.isNull(course)) {
            LOGGER.warn("creating CourseServiceImpl update");
            throw new InputDataInCorrectRuntimeException("Course must be not null");
        }
        courseDao.update(courseMapper.courseToCourseEntity(course));
    }

    @Override
    public boolean delete(Course course) {
        if (Objects.isNull(course)) {
            LOGGER.warn("creating CourseServiceImpl deleteTopic");
            throw new InputDataInCorrectRuntimeException("Course must be not null");
        }
        return courseDao.delete(courseMapper.courseToCourseEntity(course));
    }

    @Override
    public List<Course> getAllCourses(int row, int limit) {
        List<CourseEntity> courseEntities = courseDao.findAll();
        return courseEntities.isEmpty() ?
                Collections.emptyList() : courseEntities.stream()
                .map(courseMapper::courseEntityToCourse)
                .collect(Collectors.toList());
    }

    @Override
    public long getAllCoursesCount() {
        return courseDao.findCountCourses();
    }

    @Override
    public List<String> findAllCourseNames() {
        return null;
    }

    @Override
    public List<Integer> findAllDurations() {
        return null;
    }

    @Override
    public List<Integer> findAllStudentsAmount() {
        return null;
    }

    @Override
    public List<String> findCourseNameByName(String name) {
        return null;
    }

    @Override
    public List<String> findAllTopics() {
        return null;
    }

    @Override
    public List<Integer> findAllTeacherNames() {
        return null;
    }

    @Override
    public List<Integer> findTeacherIdByName(String name) {
        return null;
    }
}
