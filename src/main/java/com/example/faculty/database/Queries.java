package com.example.faculty.database;

public class Queries {

    //User
    public static final String CREATE_USER = "INSERT INTO facultyservlet.user(created_date, first_name, second_name, last_name, " +
            "email, password, role) VALUES(?,?,?,?,?,?,?)";
    public static final String GET_BY_ID_USER = "SELECT * FROM facultyservlet.user WHERE id=?";
    public static final String GET_ALL_USERS = "SELECT * FROM facultyservlet.user";
    public static final String UPDATE_USER_BY_ID = "UPDATE facultyservlet.user SET " +
            "created_date=?, " +
            "first_name=?, " +
            "second_name=?, " +
            "last_name=?, " +
            "email=?, " +
            "role=? " +
            "WHERE id=?";
    public static final String DELETE_USER = "DELETE FROM facultyservlet.user WHERE id=?";
    public static final String GET_USER_BY_EMAIL = "SELECT * FROM facultyservlet.user WHERE email=?";
    public static final String GET_USER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM facultyservlet.user WHERE email=? AND password=?";
    public static final String IS_EXISTS_STUDENT_BY_EMAIL_AND_PASSWORD = "SELECT * FROM facultyservlet.user " +
            "WHERE email=? AND password=? AND role='STUDENT'";
    public static final String IS_EXISTS_TEACHER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM facultyservlet.user " +
            "WHERE email=? AND password=? AND role='TEACHER'";
    public static final String IS_EXISTS_ADMIN_BY_EMAIL_AND_PASSWORD = "SELECT * FROM facultyservlet.user " +
            "WHERE email=? AND password=? AND role='ADMINISTRATOR'";
    public static final String GET_ALL_BY_USER_ROLE_NAME = "SELECT * FROM facultyservlet.user WHERE role=? ORDER BY created_date DESC";
    public static final String COUNT_STUDENTS = "SELECT count(*) FROM  facultyservlet.user WHERE role='STUDENT'";
    public static final String READ_STUDENTS_WITH_LIMIT = "SELECT * FROM  facultyservlet.user WHERE role='STUDENT' ORDER BY  id  DESC limit ?, ?";
    public static final String COUNT_TEACHERS = "SELECT count(*) FROM  facultyservlet.user WHERE role='TEACHER'";
    public static final String READ_TEACHERS_WITH_LIMIT = "SELECT * FROM  facultyservlet.user WHERE role='TEACHER' ORDER BY  id  DESC limit ?, ?";
    public static final String FIND_ALL_TEACHERS = "SELECT * FROM  facultyservlet.user WHERE role='TEACHER'";


    //Topic
    public static final String CREATE_TOPIC = "INSERT INTO topic(created_date, name) VALUES(?,?)";
    public static final String GET_BY_ID_TOPIC = "SELECT * FROM topic WHERE id = ?";
    public static final String GET_ALL_TOPICS = "SELECT * FROM topic";
    public static final String UPDATE_TOPIC = "UPDATE topic SET " +
            "created_date=?, " +
            "name=? " +
            "WHERE id=?";
    public static final String DELETE_TOPIC = "DELETE FROM topic WHERE id=?";
    public static final String COUNT_TOPICS = "SELECT count(*) FROM  facultyservlet.topic";
    public static final String READ_TOPICS_WITH_LIMIT = "SELECT * FROM  facultyservlet.topic ORDER BY  id  DESC limit ?, ?";

    //Course
    public static final String CREATE_COURSE = "INSERT INTO facultyservlet.coures(created_date, name, status, students_amount, " +
            "enroll_students, duration, topic_id, teacher_id) VALUES(?,?,?,?,?,?,?,?)";
    public static final String GET_COURSE_BY_ID = "SELECT * FROM facultyservlet.course WHERE id = ?";
    public static final String GET_COURSE_BY_NAME = "SELECT * FROM facultyservlet.course WHERE name = ?";
    public static final String GET_ALL_COURSES = "SELECT * FROM facultyservlet.course";
    public static final String UPDATE_COURSE = "UPDATE facultyservlet.course SET " +
            "name  = ?, " +
            "status = ?, " +
            "students_amount = ?, " +
            "enroll_students = ?, " +
            "duration = ?, " +
            "topic_id = ?, " +
            "teacher_id = ?, " +
            "WHERE id = ?";
    public static final String DELETE_COURSE = "DELETE FROM facultyservlet.course WHERE id = ?";

    //Enroll
    public static final String CREATE_ENROLL = "INSERT INTO facultyservlet.enroll(created_date, id_student, id_course) VALUES(?,?,?)";
    public static final String GET_ENROLL_BY_ID = "SELECT * FROM facultyservlet.enroll WHERE id = ?";
    public static final String GET_ALL_ENROLL = "SELECT * FROM facultyservlet.enroll";
    public static final String UPDATE_ENROLL = "UPDATE facultyservlet.enroll SET " +
            "id_student  = ?, " +
            "id_course = ?, " +
            "WHERE id = ?";
    public static final String DELETE_ENROLL = "DELETE FROM facultyservlet.enroll WHERE id = ?";

    //Gradebook
    public static final String CREATE_GRADEBOOK = "INSERT INTO facultyservlet.gradebook(created_date, id_student, id_course, mark) VALUES(?,?,?,?)";
    public static final String GET_GRADEBOOK_BY_ID = "SELECT * FROM facultyservlet.gradebook WHERE id = ?";
    public static final String GET_ALL_GRADEBOOK = "SELECT * FROM facultyservlet.gradebook";
    public static final String GRADEBOOK_ENROLL = "UPDATE facultyservlet.gradebook SET " +
            "id_student  = ?, " +
            "id_course = ?, " +
            "mark = ?, " +
            "WHERE id = ?";
    public static final String DELETE_GRADEBOOK = "DELETE FROM facultyservlet.gradebook WHERE id = ?";


}