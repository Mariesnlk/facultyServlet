package com.example.faculty.dao.impl;

import com.example.faculty.dao.interf.GradeBookDao;
import com.example.faculty.database.DBHelper;
import com.example.faculty.model.entity.CourseEntity;
import com.example.faculty.model.entity.EnrollEntity;
import com.example.faculty.model.entity.GradeBookEntity;
import com.example.faculty.model.entity.UserEntity;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.example.faculty.database.Queries.*;

public class GradeBookDaoImpl extends AbstractGenericDao<GradeBookEntity>implements GradeBookDao {

    private static final Logger LOGGER = Logger.getLogger(GradeBookDaoImpl.class);

    public GradeBookDaoImpl(DBHelper connection) {
        super(connection);
    }

    @Override
    public void create(GradeBookEntity entity) {
        insert(entity, CREATE_GRADEBOOK);
    }

    @Override
    public GradeBookEntity findById(Long id) {
        return null;
    }

    @Override
    public List<GradeBookEntity> findAll() {
        return null;
    }

    @Override
    public void update(GradeBookEntity entity) {

    }

    @Override
    public boolean delete(GradeBookEntity entity) {
        return false;
    }

    @Override
    public Boolean existsGradeBookByCourseAndStudent(Long course, Long student) {
        return isExistWithTwoLongParameters(course, student, IS_EXISTS_GRADEBOOK_BY_COURSE_AND_USER);
    }

    @Override
    public GradeBookEntity findGradeBookByCourseAndStudent(Long course, Long student) {
        return getElementByTwoLongParam(course, student, IS_EXISTS_GRADEBOOK_BY_COURSE_AND_USER);
    }

    @Override
    protected void setInsertElementProperties(PreparedStatement statement, GradeBookEntity element) throws SQLException {
        java.sql.Date printDate = new java.sql.Date(element.getDate().getTime());

        statement.setDate(1, printDate);
        statement.setLong(2, element.getStudentEntity());
        statement.setLong(3, element.getCourseEntity());
        statement.setInt(4, element.getMark());
    }

    @Override
    protected void setUpdateElementProperties(PreparedStatement statement, GradeBookEntity element) throws SQLException {
        java.sql.Date printDate = new java.sql.Date(element.getDate().getTime());

        statement.setDate(1, printDate);
        statement.setLong(2, element.getStudentEntity());
        statement.setLong(3, element.getCourseEntity());
        statement.setInt(4, element.getMark());
        statement.setLong(5, element.getGradeBookId());
    }

    @Override
    protected GradeBookEntity parseToOneElement(ResultSet resultSet) throws SQLException {
        return new GradeBookEntity.Builder()
                .setGradeBookId(resultSet.getLong("id"))
                .setDate(resultSet.getDate("created_date"))
                .setCourseEntity(resultSet.getLong("course_id"))
                .setStudentEntity(resultSet.getLong("student_id"))
                .setMark(resultSet.getInt("mark"))
                .build();
    }
}
