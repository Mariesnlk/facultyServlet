package com.example.faculty.database;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {

    private static final Logger logger = Logger.getLogger(DBHelper.class);

    private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/facultyservlet?autoReconnect=true&useSSL=false";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER_NAME);//for MySQL database
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            logger.warn("getConnection error", e);
        }
        return connection;
    }

    public static void main(String[] args) {
        DBHelper objectDBHelper = new DBHelper();

        System.out.println(objectDBHelper.getConnection());
    }
}
