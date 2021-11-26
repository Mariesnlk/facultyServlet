package com.example.faculty.dao.impl;

import com.example.faculty.dao.interf.TopicDao;
import com.example.faculty.database.DBHelper;
import com.example.faculty.model.entity.TopicEntity;
import com.example.faculty.model.entity.UserEntity;
import com.example.faculty.model.enums.UserRole;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.faculty.database.Queries.COUNT_TOPICS;
import static com.example.faculty.database.Queries.READ_TOPICS_WITH_LIMIT;

public class TopicDaoImpl extends AbstractGenericDao<TopicEntity> implements TopicDao {

    private static final Logger LOGGER = Logger.getLogger(TopicDaoImpl.class);

    public TopicDaoImpl(DBHelper connection) {
        super(connection);

    }

    @Override
    protected void setInsertElementProperties(PreparedStatement statement, TopicEntity element) throws SQLException {

    }

    @Override
    protected void setUpdateElementProperties(PreparedStatement statement, TopicEntity element) throws SQLException {

    }

    @Override
    protected TopicEntity parseToOneElement(ResultSet resultSet) throws SQLException {
        return new TopicEntity.Builder()
                .setTopicId(resultSet.getLong("id"))
                .setDate(resultSet.getDate("created_date"))
                .setTopicName(resultSet.getString("name"))
                .build();
    }

    @Override
    public void create(TopicEntity entity) {

    }

    @Override
    public TopicEntity findById(Long id) {
        return null;
    }

    @Override
    public List<TopicEntity> findAll() {
        return null;
    }

    @Override
    public void update(TopicEntity entity) {

    }

    @Override
    public boolean delete(TopicEntity entity) {
        return false;
    }

    @Override
    public Optional<TopicEntity> findTopicById(Long topicId) {
        return Optional.empty();
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
        long countOrders = 0;
        ResultSet rs = null;
        try (PreparedStatement ps = connector.getConnection().prepareStatement(COUNT_TOPICS)) {

            rs = ps.executeQuery();

            LOGGER.debug("Executed query" + COUNT_TOPICS);
            if (rs.next()) {
                LOGGER.debug("check is rs has next");
                countOrders = rs.getLong(1);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException occurred in TopicDaoImpl ", e);
        }
        return countOrders;
    }

    @Override
    public List<TopicEntity> findAllTopics(int row, int limit) {
        ResultSet rs = null;
        List<TopicEntity> topics = new ArrayList<>();
        try (PreparedStatement ps = connector.getConnection().prepareStatement(READ_TOPICS_WITH_LIMIT)) {
            ps.setInt(1, row);
            ps.setInt(2, limit);
            rs = ps.executeQuery();
            return getOrders(topics, rs);
        } catch (SQLException e) {
            LOGGER.error("SQLException occurred in TopicDaoImpl ", e);
            return null;
        }
    }


    private List<TopicEntity> getOrders(List<TopicEntity> topics, ResultSet rs) throws SQLException {
        while (rs.next()) {
            LOGGER.debug("check is rs has next");
            TopicEntity topic = parseToOneElement(rs);
            topics.add(topic);
        }
        return topics;
    }
}
