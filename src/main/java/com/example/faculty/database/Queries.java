package com.example.faculty.database;

public class Queries {

    //User
    public static final String CREATE_USER = "INSERT INTO facultyservlet.user(firstName, secondName, lastName, email, password, role) VALUES(?,?,?,?,?,?)";
    public static final String GET_BY_ID_USER = "SELECT * FROM facultyservlet.user WHERE userId = ?";
    public static final String GET_ALL_USERS = "SELECT * FROM facultyservlet.user";
    public static final String UPDATE_USER = "UPDATE facultyservlet.user SET " +
            "firstName  = ?, " +
            "secondName = ?, " +
            "lastName = ?, " +
            "email = ?, " +
            "password = ?, " +
            "WHERE userId = ?";
    public static final String DELETE_USER = "DELETE FROM facultyservlet.user WHERE userId = ?";
    public static final String GET_USER_BY_EMAIL = "SELECT * FROM facultyservlet.user WHERE email = ?";
    // TODO: 22.11.2021 without ordering
    public static final String GET_ALL_BY_USER_ROLE_NAME = "SELECT * FROM facultyservlet.user WHERE role = ?";

    //Topic
    public static final String CREATE_TOPIC = "INSERT INTO topic(topicName) VALUES(?)";
    public static final String GET_BY_ID_TOPIC = "SELECT * FROM topic WHERE topicId = ?";
    public static final String GET_ALL_TOPICS = "SELECT * FROM topic";
    public static final String UPDATE_TOPIC = "UPDATE topic SET " +
            "topicName  =  ? " +
            "WHERE topicId = ?";
    public static final String DELETE_TOPIC = "DELETE FROM topic WHERE topicId = ?";


}