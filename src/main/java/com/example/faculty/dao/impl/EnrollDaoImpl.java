package com.example.faculty.dao.impl;

import com.example.faculty.dao.interf.EnrollDao;
import com.example.faculty.database.DBHelper;
import com.example.faculty.model.entity.CourseEntity;
import com.example.faculty.model.entity.EnrollEntity;
import com.example.faculty.model.entity.UserEntity;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.example.faculty.database.Queries.CREATE_ENROLL;
import static com.example.faculty.database.Queries.IS_EXISTS_ENROLL_BY_COURSE_AND_USER;

public class EnrollDaoImpl extends AbstractGenericDao<EnrollEntity> implements EnrollDao {

    private static final Logger LOGGER = Logger.getLogger(EnrollDaoImpl.class);

    public EnrollDaoImpl(DBHelper connection) {
        super(connection);
    }

    @Override
    public void create(EnrollEntity enrollEntity) {
        insert(enrollEntity, CREATE_ENROLL);
    }

    @Override
    public EnrollEntity findById(Long id) {
        return null;
    }

    @Override
    public List<EnrollEntity> findAll() {
        return null;
    }

    @Override
    public void update(EnrollEntity entity) {

    }

    @Override
    public boolean delete(EnrollEntity entity) {
        return false;
    }

    @Override
    public Boolean existsEnrollByCourseAndUser(Long courseId, Long userId) {
        return isExistWithTwoLongParameters(courseId, userId, IS_EXISTS_ENROLL_BY_COURSE_AND_USER);
    }

    @Override
    public void deleteByCourseAndUser(CourseEntity courseEntity, UserEntity userEntity) {

    }

    @Override
    protected void setInsertElementProperties(PreparedStatement statement, EnrollEntity element) throws SQLException {
        java.sql.Date printDate = new java.sql.Date(element.getDate().getTime());

        statement.setDate(1, printDate);
        statement.setLong(2, element.getStudent());
        statement.setLong(3, element.getCourseEntity());
      }

    @Override
    protected void setUpdateElementProperties(PreparedStatement statement, EnrollEntity element) throws SQLException {
        java.sql.Date printDate = new java.sql.Date(element.getDate().getTime());
        statement.setDate(1, printDate);
        statement.setLong(2, element.getStudent());
        statement.setLong(3, element.getCourseEntity());
        statement.setLong(4, element.getEnrollId());
    }

    @Override
    protected EnrollEntity parseToOneElement(ResultSet resultSet) throws SQLException {
        return new EnrollEntity.Builder()
                .setEnrollId(resultSet.getLong("id"))
                .setDate(resultSet.getDate("created_date"))
                .setCourse(resultSet.getLong("course_id"))
                .setUser(resultSet.getLong("student_id"))
                .build();
    }
}
