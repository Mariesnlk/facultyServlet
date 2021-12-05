package com.example.faculty.dao.impl;

import com.example.faculty.dao.interf.TopicDao;
import com.example.faculty.database.DBHelper;
import com.example.faculty.model.entity.TopicEntity;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.faculty.database.Queries.*;

public class TopicDaoImpl extends AbstractGenericDao<TopicEntity> implements TopicDao {

    private static final Logger LOGGER = Logger.getLogger(TopicDaoImpl.class);

    public TopicDaoImpl(DBHelper connection) {
        super(connection);

    }

    @Override
    public void create(TopicEntity topicEntity) {
        insert(topicEntity, CREATE_TOPIC);
    }

    @Override
    public TopicEntity findById(Long id) {
        return getElementByLongParam(id, GET_BY_ID_TOPIC);
    }

    @Override
    public List<TopicEntity> findAll() {
        return getList(GET_ALL_TOPICS);
    }

    @Override
    public void update(TopicEntity entity) {
        update(entity, UPDATE_TOPIC);
    }

    @Override
    public boolean delete(TopicEntity entity) {
        return delete(entity.getTopicId(), DELETE_TOPIC);
    }

    @Override
    public Boolean existsTopicByName(String topicName) {
        return null;
    }

    @Override
    public List<TopicEntity> findByOrderByCreatedDate() {
        return null;
    }

    @Override
    public long findCountTopics() {
        return findCount(COUNT_TOPICS);
    }

    @Override
    public List<TopicEntity> findAllTopics(int row, int limit) {
        ResultSet rs = null;
        List<TopicEntity> topics = new ArrayList<>();
        try (PreparedStatement ps = connector.getConnection().prepareStatement(READ_TOPICS_WITH_LIMIT)) {
            ps.setInt(1, row);
            ps.setInt(2, limit);
            rs = ps.executeQuery();
            return getTopics(topics, rs);
        } catch (SQLException e) {
            LOGGER.error("SQLException occurred in TopicDaoImpl ", e);
            return null;
        }
    }


    private List<TopicEntity> getTopics(List<TopicEntity> topics, ResultSet rs) throws SQLException {
        while (rs.next()) {
            TopicEntity topic = parseToOneElement(rs);
            topics.add(topic);
        }
        return topics;
    }

    @Override
    protected void setInsertElementProperties(PreparedStatement statement, TopicEntity element) throws SQLException {
        java.sql.Date printDate = new java.sql.Date(element.getDate().getTime());
        statement.setDate(1, printDate);
        statement.setString(2, element.getTopicName());
    }

    @Override
    protected void setUpdateElementProperties(PreparedStatement statement, TopicEntity element) throws SQLException {
        java.sql.Date printDate = new java.sql.Date(element.getDate().getTime());
        statement.setDate(1, printDate);
        statement.setString(2, element.getTopicName());
        statement.setLong(3, element.getTopicId());
    }

    @Override
    protected TopicEntity parseToOneElement(ResultSet resultSet) throws SQLException {
        return new TopicEntity.Builder()
                .setTopicId(resultSet.getLong("id"))
                .setDate(resultSet.getDate("created_date"))
                .setTopicName(resultSet.getString("name"))
                .build();
    }
}
