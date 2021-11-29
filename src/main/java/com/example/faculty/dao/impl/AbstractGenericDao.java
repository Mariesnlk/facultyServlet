package com.example.faculty.dao.impl;

import com.example.faculty.database.DBHelper;
import com.example.faculty.exception.DataBaseRuntimeException;
import com.example.faculty.model.entity.TopicEntity;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.faculty.database.Queries.COUNT_COURSES;
import static com.example.faculty.database.Queries.READ_TOPICS_WITH_LIMIT;


public abstract class AbstractGenericDao<E> {

    protected DBHelper connector;
    protected static final Logger LOGGER = Logger.getLogger(AbstractGenericDao.class);

    protected AbstractGenericDao(DBHelper connector) {
        this.connector = connector;
    }

    protected void insert(E element, String query) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            setInsertElementProperties(statement, element);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("inser exeption" + e);
            throw new DataBaseRuntimeException("Insert exeption", e);
        }
    }

    protected E getElementByIntegerParam(Long id, String query) {
        ResultSet rs = null;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            rs = statement.executeQuery();
            if (rs.next()) {
                return parseToOneElement(rs);
            }
        } catch (SQLException e) {
            LOGGER.warn("getElementByIntegerParam error", e);
            throw new DataBaseRuntimeException("getElementByIntegerParam error", e);
        }
        return null;
    }


    protected void update(E entity, String query) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            setUpdateElementProperties(preparedStatement, entity);
            preparedStatement.executeUpdate();
            LOGGER.info("AbstractGenericDao - update");
        } catch (SQLException e) {
            LOGGER.warn("Can not update element", e);
            throw new DataBaseRuntimeException("Can not update element", e);
        }
    }


    protected E getElementByStringParam(String data, String query) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, data);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return parseToOneElement(resultSet);
            }
        } catch (SQLException e) {
            LOGGER.warn(" getElementByStringParam error", e);
            throw new DataBaseRuntimeException("getElementByStringParam error", e);
        }
        return null;
    }

    protected E getElementByTwoStringParam(String data, String secondData, String query) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, data);
            statement.setString(2, secondData);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return parseToOneElement(resultSet);
            }
        } catch (SQLException e) {
            LOGGER.warn(" getElementByStringParam error", e);
            throw new DataBaseRuntimeException("getElementByStringParam error", e);
        }
        return null;
    }


    protected List<E> getList(String query) {
        ResultSet resultSet = null;
        List<E> list;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            resultSet = statement.executeQuery();
            list = parseAllElements(resultSet);
        } catch (SQLException e) {
            LOGGER.warn("getList error", e);
            throw new DataBaseRuntimeException("getList error", e);
        }

        return list;
    }

    protected List<E> parseAllElements(ResultSet resultSet) {
        List<E> elements = new ArrayList<>();
        try {
            while (resultSet.next()) {
                elements.add(parseToOneElement(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.warn("parseAllElements ResultSet", e);
            throw new DataBaseRuntimeException("parseAllElements ResultSet", e);
        }
        return elements;
    }

    protected boolean isExist(String data, String secondData, String query) {
        ResultSet rs = null;

        try (Connection connection = connector.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(query);
            LOGGER.info(data);
            LOGGER.info(secondData);
            ps.setString(1, data);
            ps.setString(2, secondData);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            LOGGER.warn("SQLException isExist", e);
        }
        return false;
    }

    protected boolean isExistWithOneStringParameter(String data, String query) {
        ResultSet rs = null;
        try (Connection connection = connector.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, data);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            LOGGER.warn("SQLException isExist", e);
        }
        return false;
    }

    protected boolean delete(Long id, String query) {
        boolean result = false;
        int changedRowsNumber = 0;

        try (Connection connection = connector.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, id);
            changedRowsNumber = ps.executeUpdate();
            System.out.println("changedRowsNumber=" + changedRowsNumber);
            if (changedRowsNumber > 0) {
                result = true;
            } else result = false;
        } catch (SQLException e) {
            result = false;
            LOGGER.warn("getElementByIntegerParam error", e);
            throw new DataBaseRuntimeException("getElementByIntegerParam error", e);
        }
        return result;
    }

    public long findCount(String query) {
        long countsCourses = 0;
        ResultSet rs = null;
        try (PreparedStatement ps = connector.getConnection().prepareStatement(query)) {

            rs = ps.executeQuery();

            LOGGER.debug("Executed query" + query);
            if (rs.next()) {
                LOGGER.debug("check is rs has next");
                countsCourses = rs.getLong(1);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException occurred ", e);
        }
        return countsCourses;
    }

    protected abstract void setInsertElementProperties(PreparedStatement statement, E element) throws SQLException;

    protected abstract void setUpdateElementProperties(PreparedStatement statement, E element) throws SQLException;

    protected abstract E parseToOneElement(ResultSet resultSet) throws SQLException;
}
