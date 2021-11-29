package com.example.faculty.dao.impl;

import com.example.faculty.dao.interf.CourseDao;
import com.example.faculty.database.DBHelper;
import com.example.faculty.model.entity.CourseEntity;
import com.example.faculty.model.enums.CourseStatus;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.faculty.database.Queries.*;

public class CourseDaoImpl extends AbstractGenericDao<CourseEntity> implements CourseDao {

    private static final Logger LOGGER = Logger.getLogger(CourseDaoImpl.class);

    public CourseDaoImpl(DBHelper connection) {
        super(connection);
    }

    @Override
    public Boolean existsCourseByName(String name) {
        return null;
    }

    @Override
    public long findCountCourses() {
        return findCount(COUNT_COURSES);
    }

    @Override
    public List<CourseEntity> findAllCourses(int row, int limit) {
        ResultSet rs = null;
        List<CourseEntity> courses = new ArrayList<>();
        try (PreparedStatement ps = connector.getConnection().prepareStatement(READ_COURSES_WITH_LIMIT)) {
            ps.setInt(1, row);
            ps.setInt(2, limit);
            rs = ps.executeQuery();
            return getCourses(courses, rs);
        } catch (SQLException e) {
            LOGGER.error("SQLException occurred in TopicDaoImpl ", e);
            return null;
        }
    }


    private List<CourseEntity> getCourses(List<CourseEntity> topics, ResultSet rs) throws SQLException {
        while (rs.next()) {
            CourseEntity courseEntity = parseToOneElement(rs);
            topics.add(courseEntity);
        }
        return topics;
    }

    @Override
    public void create(CourseEntity courseEntity) {
        insert(courseEntity, CREATE_COURSE);
    }

    @Override
    public CourseEntity findById(Long id) {
        return getElementByIntegerParam(id, GET_COURSE_BY_ID);
    }

    @Override
    public List<CourseEntity> findAll() {
        return getList(GET_ALL_COURSES);
    }

    @Override
    public void update(CourseEntity entity) {
        update(entity, UPDATE_COURSE);
    }

    @Override
    public boolean delete(CourseEntity entity) {
        return delete(entity.getCourseId(), DELETE_COURSE);
    }


    @Override
    protected void setInsertElementProperties(PreparedStatement statement, CourseEntity element) throws SQLException {
        java.sql.Date printDate = new java.sql.Date(element.getDate().getTime());

        statement.setDate(1, printDate);
        statement.setString(2, element.getCourseName());
        statement.setString(3, element.getStatus().name());
        statement.setInt(4, element.getStudentsAmount());
        statement.setInt(5, element.getEnrollStudents());
        statement.setInt(6, element.getDuration());
        statement.setLong(7, element.getTopic());
        statement.setLong(8, element.getTeacher());
    }

    @Override
    protected void setUpdateElementProperties(PreparedStatement statement, CourseEntity element) throws SQLException {
        java.sql.Date printDate = new java.sql.Date(element.getDate().getTime());
        statement.setDate(1, printDate);
        statement.setString(2, element.getCourseName());
        statement.setString(3, element.getStatus().name());
        statement.setInt(4, element.getStudentsAmount());
        statement.setInt(5, element.getEnrollStudents());
        statement.setInt(6, element.getDuration());
        statement.setLong(7, element.getTopic());
        statement.setLong(8, element.getTeacher());
        statement.setLong(9, element.getCourseId());
    }

    @Override
    protected CourseEntity parseToOneElement(ResultSet resultSet) throws SQLException {
        return new CourseEntity.Builder()
                .setCourseId(resultSet.getLong("id"))
                .setDate(resultSet.getDate("created_date"))
                .setTopic(resultSet.getLong("topic_id"))
                .setTeacher(resultSet.getLong("teacher_id"))
                .setCourseName(resultSet.getString("name"))
                .setDuration(resultSet.getInt("duration"))
                .setStudentsAmount(resultSet.getInt("students_amount"))
                .setEnrollStudents(resultSet.getInt("enroll_students"))
                .setCourseStatus(CourseStatus.valueOf(resultSet.getString("status")))
                .build();
    }
}
