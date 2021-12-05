package com.example.faculty.dao.impl;

import com.example.faculty.dao.interf.StudentMarkDao;
import com.example.faculty.database.DBHelper;
import com.example.faculty.model.domain.StudentMark;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.example.faculty.database.Queries.STUDENT_MARK;


public class StudentMarkDaoImpl extends AbstractGenericDao<StudentMark> implements StudentMarkDao {

    private static final Logger LOGGER = Logger.getLogger(StudentMarkDaoImpl.class);

    public StudentMarkDaoImpl(DBHelper connection) {
        super(connection);
    }


    @Override
    protected void setInsertElementProperties(PreparedStatement statement, StudentMark element) throws SQLException {

    }

    @Override
    protected void setUpdateElementProperties(PreparedStatement statement, StudentMark element) throws SQLException {

    }

    @Override
    protected StudentMark parseToOneElement(ResultSet resultSet) throws SQLException {
        return new StudentMark.Builder()
                .setId(resultSet.getLong("id"))
                .setFirstName(resultSet.getString("first_name"))
                .setSecondName(resultSet.getString("second_name"))
                .setLastName(resultSet.getString("last_name"))
                .setMark(resultSet.getInt("mark"))
                .build();
    }

    @Override
    public List<StudentMark> findAllStudentsMark(Long courseId) {
        return getListWithLongParameter(courseId, STUDENT_MARK);
    }
}
