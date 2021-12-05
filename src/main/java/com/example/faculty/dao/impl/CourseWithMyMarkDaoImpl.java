package com.example.faculty.dao.impl;

import com.example.faculty.dao.interf.CourseWithMyMarkDao;
import com.example.faculty.database.DBHelper;
import com.example.faculty.model.domain.CoursesWithMyMark;
import com.example.faculty.model.enums.CourseStatus;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.example.faculty.database.Queries.ALL_STUDENT_COURSES;

public class CourseWithMyMarkDaoImpl extends AbstractGenericDao<CoursesWithMyMark> implements CourseWithMyMarkDao {

    private static final Logger LOGGER = Logger.getLogger(CourseWithMyMarkDaoImpl.class);

    public CourseWithMyMarkDaoImpl(DBHelper connection) {
        super(connection);
    }

    @Override
    protected void setInsertElementProperties(PreparedStatement statement, CoursesWithMyMark element) throws SQLException {

    }

    @Override
    protected void setUpdateElementProperties(PreparedStatement statement, CoursesWithMyMark element) throws SQLException {

    }

    @Override
    protected CoursesWithMyMark parseToOneElement(ResultSet resultSet) throws SQLException {
        return new CoursesWithMyMark.Builder()
                .setName(resultSet.getString("name"))
                .setDuration(resultSet.getInt("duration"))
                .setStudentsAmount(resultSet.getInt("students_amount"))
                .setTopicId(resultSet.getLong("topic_id"))
                .setTeacherId(resultSet.getLong("teacher_id"))
                .setStatus(CourseStatus.valueOf(resultSet.getString("status")))
                .setMark(resultSet.getInt("mark"))
                .build();
    }

    @Override
    public List<CoursesWithMyMark> findAllStudentCourses(Long studentId) {
        LOGGER.info("Student courses --- " + getListWithLongParameter(studentId, ALL_STUDENT_COURSES));
        return getListWithLongParameter(studentId, ALL_STUDENT_COURSES);
    }

}
