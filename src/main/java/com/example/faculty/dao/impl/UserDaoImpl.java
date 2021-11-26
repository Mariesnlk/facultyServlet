package com.example.faculty.dao.impl;

import com.example.faculty.dao.interf.UserDao;
import com.example.faculty.database.DBHelper;
import com.example.faculty.model.entity.UserEntity;
import com.example.faculty.model.enums.UserRole;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.faculty.database.Queries.*;

public class UserDaoImpl extends AbstractGenericDao<UserEntity> implements UserDao {

    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    public UserDaoImpl(DBHelper connection) {
        super(connection);

    }

    @Override
    public void create(UserEntity user) {
        insert(user, CREATE_USER);
    }

    @Override
    public UserEntity findById(Long id) {
        return getElementByIntegerParam(id, GET_BY_ID_USER);
    }

    @Override
    public List<UserEntity> findAll() {
        return getList(GET_ALL_USERS);
    }

    @Override
    public void update(UserEntity userEntity) {
        try (PreparedStatement ps = connector.getConnection().prepareStatement(UPDATE_USER_BY_ID)) {
            java.sql.Date printDate = new java.sql.Date(userEntity.getDate().getTime());
            ps.setDate(1, printDate);
            ps.setString(2, userEntity.getFirstName());
            ps.setString(3, userEntity.getSecondName());
            ps.setString(4, userEntity.getLastName());
            ps.setString(5, userEntity.getEmail());
            ps.setString(6, userEntity.getRole().name());
            ps.setLong(7, userEntity.getUserId());
            ps.execute();
            LOGGER.info("Executed query" + UPDATE_USER_BY_ID);
        } catch (SQLException e) {
            LOGGER.error("SQLException occurred in UserDaoImpl", e);
        }
    }

    @Override
    public boolean delete(UserEntity userEntity) {
        return delete(userEntity.getUserId(), DELETE_USER);
    }

    @Override
    public boolean isEmailExists(String email) {
        return isExistWithOneStringParameter(email, GET_USER_BY_EMAIL);
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        return getElementByStringParam(email, GET_USER_BY_EMAIL);
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
    public long findCountStudents() {
        long countStudents = 0;
        ResultSet rs = null;
        try (PreparedStatement ps = connector.getConnection().prepareStatement(COUNT_STUDENTS)) {

            rs = ps.executeQuery();

            LOGGER.debug("Executed query" + COUNT_STUDENTS);
            if (rs.next()) {
                LOGGER.debug("check is rs has next");
                countStudents = rs.getLong(1);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException occurred in UserDaoImpl ", e);
        }
        return countStudents;
    }

    @Override
    public List<UserEntity> findAllStudents(int row, int limit) {
        ResultSet rs = null;
        List<UserEntity> topics = new ArrayList<>();
        try (PreparedStatement ps = connector.getConnection().prepareStatement(READ_STUDENTS_WITH_LIMIT)) {
            ps.setInt(1, row);
            ps.setInt(2, limit);
            rs = ps.executeQuery();
            return getUsers(topics, rs);
        } catch (SQLException e) {
            LOGGER.error("SQLException occurred in TopicDaoImpl ", e);
            return null;
        }
    }

    @Override
    public long findCountTeachers() {
        long countTeachers = 0;
        ResultSet rs = null;
        try (PreparedStatement ps = connector.getConnection().prepareStatement(COUNT_TEACHERS)) {

            rs = ps.executeQuery();

            LOGGER.debug("Executed query" + COUNT_TEACHERS);
            if (rs.next()) {
                LOGGER.debug("check is rs has next");
                countTeachers = rs.getLong(1);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException occurred in UserDaoImpl ", e);
        }
        return countTeachers;
    }

    private List<UserEntity> getUsers(List<UserEntity> users, ResultSet rs) throws SQLException {
        while (rs.next()) {
            UserEntity user = parseToOneElement(rs);
            users.add(user);
        }
        return users;
    }

    @Override
    public List<UserEntity> findAllTeachers(int row, int limit) {
        ResultSet rs = null;
        List<UserEntity> topics = new ArrayList<>();
        try (PreparedStatement ps = connector.getConnection().prepareStatement(READ_TEACHERS_WITH_LIMIT)) {
            ps.setInt(1, row);
            ps.setInt(2, limit);
            rs = ps.executeQuery();
            return getUsers(topics, rs);
        } catch (SQLException e) {
            LOGGER.error("SQLException occurred in TopicDaoImpl ", e);
            return null;
        }
    }

    @Override
    public List<UserEntity> findAllTeachers() {
        return getList(FIND_ALL_TEACHERS);
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
