package com.example.faculty.dao.impl;

import com.example.faculty.dao.interf.UserDao;
import com.example.faculty.model.entities.User;

import java.util.List;
import java.util.logging.Logger;

public class UserDaoImpl implements UserDao {

    private static final Logger LOG = Logger.getLogger(UserDaoImpl.class.getName());

    @Override
    public void create(User entity) {

    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }
}
