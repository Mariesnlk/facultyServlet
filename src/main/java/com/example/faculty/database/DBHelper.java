package com.example.faculty.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {

    private final String DRIVER_NAME = "com.mysql.jdbc.Driver";

    //    private final String URL = "jdbc:mysql://localhost:3306/db_supermarket?autoReconnect=true&useSSL=false";
    private final String URL = "jdbc:mysql://localhost:3306/facultyservlet";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER_NAME);//for MySQL database
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    public static void main(String[] args) {
        DBHelper objectDBHelper = new DBHelper();

        System.out.println(objectDBHelper.getConnection());
    }
}
