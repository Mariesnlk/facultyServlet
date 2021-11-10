package com.example.faculty.dao.interf;

import com.example.faculty.model.entities.User;

public interface UserDao extends CrudDao<User, Long> {

    User findByEmail(String email);

}