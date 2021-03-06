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
    public static final String GET_TEACHER_BY_EMAIL = "SELECT * FROM facultyservlet.user WHERE email=? AND role='TEACHER'";
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
    public static final String IS_EXISTS_TEACHER_WITH_EMAIL = "SELECT * FROM  facultyservlet.user WHERE email=? AND role='TEACHER'";
    public static final String UPDATE_PASSWORD_BY_USER_ID = "UPDATE facultyservlet.user SET " +
            "password=? " +
            "WHERE id=?";

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
    public static final String CREATE_COURSE = "INSERT INTO facultyservlet.course(created_date, name, status, students_amount, " +
            "enroll_students, duration, topic_id, teacher_id) VALUES(?,?,?,?,?,?,?,?)";
    public static final String GET_COURSE_BY_ID = "SELECT * FROM facultyservlet.course WHERE id=?";
    public static final String GET_COURSE_BY_NAME = "SELECT * FROM facultyservlet.course WHERE name = ?";
    public static final String GET_ALL_COURSES = "SELECT * FROM facultyservlet.course";
    public static final String UPDATE_COURSE = "UPDATE facultyservlet.course SET " +
            "created_date=?, " +
            "name=?, " +
            "status=?, " +
            "students_amount=?, " +
            "enroll_students=?, " +
            "duration=?, " +
            "topic_id=?, " +
            "teacher_id=? " +
            "WHERE id=?";
    public static final String DELETE_COURSE = "DELETE FROM facultyservlet.course WHERE id = ?";
    public static final String COUNT_COURSES = "SELECT count(*) FROM  facultyservlet.course";
    public static final String COUNT_TEACHER_COURSES = "SELECT count(*) FROM  facultyservlet.course WHERE teacher_id=?";
    public static final String READ_COURSES_WITH_LIMIT = "SELECT * FROM  facultyservlet.course ORDER BY  id  DESC limit ?, ?";
    public static final String READ_TEACHER_COURSES_WITH_LIMIT = "SELECT * FROM  facultyservlet.course WHERE teacher_id=? ORDER BY  id  DESC limit ?, ?";
    public static final String ALL_STUDENT_COURSES = "SELECT c.name, c.duration, c.students_amount, c.topic_id, c.teacher_id, c.status, g.mark " +
            "FROM facultyservlet.course c " +
            "INNER JOIN facultyservlet.enroll e " +
            "ON c.id = e.course_id " +
            "LEFT JOIN facultyservlet.gradebook g " +
            "ON g.course_id = c.id " +
            "WHERE e.student_id=?";
    public static final String STUDENT_MARK = "SELECT u.id, u.first_name, u.second_name, u.last_name, g.mark " +
            "FROM facultyservlet.user u " +
            "LEFT JOIN facultyservlet.enroll e " +
            "ON u.id = e.student_id " +
            "LEFT JOIN facultyservlet.gradebook g " +
            "ON g.student_id = e.student_id " +
            "WHERE e.course_id=?";

    //Enroll
    public static final String CREATE_ENROLL = "INSERT INTO facultyservlet.enroll(created_date, student_id, course_id) VALUES(?,?,?)";
    public static final String GET_ENROLL_BY_ID = "SELECT * FROM facultyservlet.enroll WHERE id = ?";
    public static final String GET_ALL_ENROLL = "SELECT * FROM facultyservlet.enroll";
    public static final String UPDATE_ENROLL = "UPDATE facultyservlet.enroll SET " +
            "created_date=?, " +
            "student_id=?, " +
            "course_id=? " +
            "WHERE id=?";
    public static final String DELETE_ENROLL = "DELETE FROM facultyservlet.enroll WHERE id = ?";
    public static final String IS_EXISTS_ENROLL_BY_COURSE_AND_USER = "SELECT * FROM facultyservlet.enroll " +
            "WHERE course_id=? AND student_id=?";

    //Gradebook
    public static final String CREATE_GRADEBOOK = "INSERT INTO facultyservlet.gradebook(created_date, student_id, course_id, mark) VALUES(?,?,?,?)";
    public static final String GET_GRADEBOOK_BY_ID = "SELECT * FROM facultyservlet.gradebook WHERE id=?";
    public static final String GET_ALL_GRADEBOOK = "SELECT * FROM facultyservlet.gradebook";
    public static final String GRADEBOOK_ENROLL = "UPDATE facultyservlet.gradebook SET " +
            "created_date  = ?, " +
            "student_id  = ?, " +
            "course_id = ?, " +
            "mark = ?, " +
            "WHERE id = ?";
    public static final String DELETE_GRADEBOOK = "DELETE FROM facultyservlet.gradebook WHERE id=?";
    public static final String IS_EXISTS_GRADEBOOK_BY_COURSE_AND_USER = "SELECT * FROM facultyservlet.gradebook " +
            "WHERE course_id=? AND student_id=?";

}