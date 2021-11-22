package com.example.faculty.service.impl;

import com.example.faculty.model.domain.User;
import com.example.faculty.service.interf.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final static String SECRETKEY = "fifi!fifi!!";

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

    @Override
    public void updatePassword(User user, String newPassword) {

    }

    @Override
    public List<User> allTeachers() {
        return null;
    }


//    @Override
//    public User getRegisteredUser(String login, String password) {
//        User registeredUser = null;
//
//        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
//        List<Employee> allEmployeesList = employeeDAO.findAll();
//
//        for (Employee employee : allEmployeesList) {
//            String decryptedPassword = AES.decrypt(employee.getPassword(), SECRETKEY);
//            if (employee.getLogin().equals(login) && decryptedPassword.equals(password)) {
//                registeredUser = employee;
//                System.out.println(registeredUser);
//                break;
//            }
////            else {
////                registeredUser = null;
////                System.out.println(registeredUser);
////            }
//        }
//        return registeredUser;
//    }

}
