package com.example.faculty.dao.impl;

import com.example.faculty.dao.interf.CourseDao;
import com.example.faculty.database.DBHelper;
import com.example.faculty.model.entities.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CourseDaoImpl implements CourseDao {

    private static final Logger LOG = Logger.getLogger(CourseDaoImpl.class.getName());

    @Override
    public void create(Course course) {
        DBHelper dbHelper = new DBHelper();
        Connection connection = dbHelper.getConnection();

        PreparedStatement ps = null;

//        try {
//            String categoryName = course.getCategory_name();
//
//            String query = "INSERT INTO db_supermarket.category(category_name) VALUES(?)";
//
//            ps = connection.prepareStatement(query);
//
//            LOG.log(Level.INFO, "Executed query" + query);
//
//            ps.setString(1, categoryName);
//
//            ps.executeUpdate();
//
//        } catch (Exception ex) {
//            System.out.println(ex);
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    LOG.log(Level.SEVERE, "SQLException occurred in CategoryDaoImpl", e);
//                    //System.out.println(e);
//                }
//            }
//        }
    }

    @Override
    public Course findById(Long courseId) {

        Course course = null;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

//        try {
//
//            String query = "SELECT * FROM db_supermarket.category WHERE category_number = ?";
//            ps = connection.prepareStatement(query);
//
//            LOG.debug("Executed query" + query);
//
//            ps.setString(1, String.valueOf(courseId));
//
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//
//                String categoryName = rs.getString("category_name");
//
//                course = new Category(courseId, categoryName);
//            }
//
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    LOG.error("SQLException occurred in CategoryDaoImpl", e);
//                    //e.printStackTrace();
//                }
//            }
//        }
        return course;
    }

    @Override
    public List<Course> findAll() {
        List<Course> categoryList = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
//        try {
//
//            String query = "SELECT * FROM db_supermarket.category";
//            ps = connection.prepareStatement(query);
//
//            LOG.debug("Executed query" + query);
//
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                Integer idCategory = rs.getInt("category_number");
//                String categoryName = rs.getString("category_name");
//
//                Category category = new Category(idCategory, categoryName);
//                categoryList.add(category);
//            }
//
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    LOG.error("SQLException occurred in CategoryDaoImpl", e);
//                    //e.printStackTrace();
//                }
//            }
//        }
        return categoryList;
    }

    @Override
    public void update(Course cou) {
        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
//        try {
//
//            Integer newIdCategory = cou.getCategory_number();
//            String newCategoryName = cou.getCategory_name();
//            ;
//
//            String query =
//                    "UPDATE db_supermarket.category SET category_name  = '" + newCategoryName +
//                            "' WHERE category_number = ?";
//
//            ps = connection.prepareStatement(query);
//
//            LOG.debug("Executed query" + query);
//
//            ps.setInt(1, newIdCategory);
//
//            ps.executeUpdate();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    LOG.error("SQLException occurred in CategoryDaoImpl", e);
//                    //e.printStackTrace();
//                }
//            }
//        }
    }

    @Override
    public boolean delete(Course course) {

        boolean result = false;
        int changedRowsNumber = 0;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
//        try {
//            Integer id = course.getCategory_number();
//
//            String query = "DELETE FROM db_supermarket.category WHERE category_number = ?";
//            ps = connection.prepareStatement(query);
//
//            LOG.debug("Executed query" + query);
//
//            ps.setInt(1, id);
//
//            //System.out.println(ps);
//            changedRowsNumber = ps.executeUpdate();
//            System.out.println("changedRowsNumber=" + changedRowsNumber);
//            if (changedRowsNumber > 0) {
//                result = true;
//            }
//
//        } catch (Exception e) {
//            System.out.println(e);
//            result = false;
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    LOG.error("SQLException occurred in CategoryDaoImpl", e);
//                    //e.printStackTrace();
//                }
//            }
//        }
        return result;
    }

    @Override
    public List<Course> findByName(String name) {
        return null;
    }

    @Override
    public List<Course> findCourseByParams(String courseName, List<Integer> duration, List<Integer> studentsAmount, List<Integer> topic, List<Integer> teacherId, String sortType) {
        return null;
    }

    @Override
    public List<Course> findAllTeachersCourses(int teacherId) {
        return null;
    }

    @Override
    public Course deleteTeacherFromCourse(int courseId) {
        return null;
    }
}
