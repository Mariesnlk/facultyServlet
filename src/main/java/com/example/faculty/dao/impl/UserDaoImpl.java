package com.example.faculty.dao.impl;

import com.example.faculty.dao.interf.UserDao;
import com.example.faculty.database.DBHelper;
import com.example.faculty.model.entity.UserEntity;
import com.example.faculty.model.enums.UserRole;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static com.example.faculty.database.Queries.*;

public class UserDaoImpl extends AbstractGenericDao<UserEntity> implements UserDao {

    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class.getName());

    public UserDaoImpl(DBHelper connection) {
        super(connection);

    }

    @Override
    public void create(UserEntity user) {
        insert(user, CREATE_USER);
    }

    @Override
    public UserEntity findById(Long id) {
        return null;
    }

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public void update(UserEntity entity) {

    }

    @Override
    public boolean delete(UserEntity entity) {
        return false;
    }

    @Override
    public boolean isEmailExists(String email) {
        return isExistWithOneStringParameter(email, GET_USER_BY_EMAIL);
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<UserEntity> findAllByUserRoleNameOrderByCreatedDate(UserRole userRoleName) {
        return null;
    }

    @Override
    public boolean isStudentExists(String email, String password) {
        return isExist(email, password, IS_EXISTS_STUDENT_BY_EMAIL_AND_PASSWORD);
    }

    @Override
    public boolean isTeacherExists(String email, String password) {
        return isExist(email, password, IS_EXISTS_TEACHER_BY_EMAIL_AND_PASSWORD);
    }

    @Override
    public boolean isAdminExists(String email, String password) {
        return isExist(email, password, IS_EXISTS_ADMIN_BY_EMAIL_AND_PASSWORD);
    }

    @Override
    public Optional<UserEntity> findUserByEmailAndPass(String email, String password) {
        return Optional.ofNullable(getElementByTwoStringParam(email, password, GET_USER_BY_EMAIL_AND_PASSWORD));
    }

    @Override
    protected void setInsertElementProperties(PreparedStatement statement, UserEntity element) throws SQLException {
        java.sql.Date printDate = new java.sql.Date(element.getDate().getTime());

        statement.setDate(1, printDate);
        statement.setString(2, element.getFirstName());
        statement.setString(3, element.getSecondName());
        statement.setString(4, element.getLastName());
        statement.setString(5, element.getEmail());
        statement.setString(6, element.getPassword());
        statement.setString(7, element.getRole().name());
    }

    @Override
    protected void setUpdateElementProperties(PreparedStatement statement, UserEntity element) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected UserEntity parseToOneElement(ResultSet resultSet) throws SQLException {
        return new UserEntity.Builder()
                .setUserId(resultSet.getLong("id"))
                .setFirstName(resultSet.getString("first_name"))
                .setSecondName(resultSet.getString("second_name"))
                .setLastName(resultSet.getString("last_name"))
                .setEmail(resultSet.getString("email"))
                .setPassword(resultSet.getString("password"))
                .setRole(UserRole.valueOf(resultSet.getString("role")))
                .build();
    }
}
