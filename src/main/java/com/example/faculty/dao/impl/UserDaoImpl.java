package com.example.faculty.dao.impl;

import com.example.faculty.dao.interf.UserDao;
import com.example.faculty.database.DBHelper;
import com.example.faculty.database.Queries;
import com.example.faculty.model.entity.UserEntity;
import com.example.faculty.model.enums.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class UserDaoImpl implements UserDao {

    private static final Logger LOG = Logger.getLogger(UserDaoImpl.class.getName());

    @Override
    public void create(UserEntity user) {
        DBHelper dbHelper = new DBHelper();
        Connection connection = dbHelper.getConnection();

        PreparedStatement ps = null;

        try {
            String firstName = user.getFirstName();
            String secondName = user.getSecondName();
            String lastName = user.getLastName();
            String email = user.getEmail();
            String password = user.getPassword();
            UserRole role = user.getRole();

            String query = Queries.CREATE_USER;

            ps = connection.prepareStatement(query);

            //LOG.debug("Executed query" + query);

            ps.setString(1, firstName);
            ps.setString(2, secondName);
            ps.setString(3, lastName);
            ps.setString(4, email);
            ps.setString(5, password);
            // TODO: 22.11.2021 check
            ps.setString(6, role.name());

            ps.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // LOG.error("SQLException occurred in OrderDaoImpl", e);
                    System.out.println(e);
                }
            }
        }
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
    public UserEntity getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<UserEntity> findAllByUserRoleNameOrderByCreatedDate(UserRole userRoleName) {
        return null;
    }
}
