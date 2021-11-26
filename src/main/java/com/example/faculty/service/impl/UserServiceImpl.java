package com.example.faculty.service.impl;

import com.example.faculty.dao.interf.UserDao;
import com.example.faculty.exception.EmailIsAlreadyTaken;
import com.example.faculty.exception.InputDataInCorrectRuntimeException;
import com.example.faculty.exception.InvalidDataRuntimeException;
import com.example.faculty.model.domain.User;
import com.example.faculty.model.entity.UserEntity;
import com.example.faculty.model.mapper.UserMapper;
import com.example.faculty.service.interf.UserService;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
    private UserDao userDao;
    private UserMapper userMapper;

    public UserServiceImpl(UserDao userDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    @Override
    public void create(User user) {
        if (Objects.isNull(user)) {
            LOGGER.warn("creating UserServiceImpl create student in database");
            throw new InputDataInCorrectRuntimeException("User is empty");
        }
        boolean isTakenEmail = userDao.isEmailExists(user.getEmail());
        if (isTakenEmail) {
            LOGGER.warn("e-mail is taken, exception occurred");
            throw new EmailIsAlreadyTaken("This email is already registered");
        }

        userDao.create(userMapper.userToUserEntityWithoutId(user));
    }

    @Override
    public User findById(Long id) {
        if (Objects.isNull(id)) {
            LOGGER.warn("find user by id");
            throw new InputDataInCorrectRuntimeException("User must be not null");
        }
        UserEntity userEntity = userDao.findById(id);
        return userMapper.userEntityToUser(userEntity);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(User user) {
        if (Objects.isNull(user)) {
            LOGGER.warn("update User");
            throw new InputDataInCorrectRuntimeException("User must be not null");
        }
        userDao.update(userMapper.userToUserEntity(user));
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

    @Override
    public User getUserByEmailAndPassword(String email, String hashPassword) {
        if (email.isEmpty() || hashPassword.isEmpty()) {
            LOGGER.warn("get user getUserByEmailAndPassword");
            throw new InputDataInCorrectRuntimeException("User email and password must be not null");
        }
        Optional<UserEntity> userEntity = userDao.findUserByEmailAndPass(email, hashPassword);

        return userEntity.map(userMapper::userEntityToUser)
                .orElseThrow(() -> new InvalidDataRuntimeException("User  is not correct"));
    }

    @Override
    public boolean isAdminExists(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            LOGGER.info("Email or password is empty");
            throw new InvalidDataRuntimeException("Email or password is empty");
        }
        return userDao.isAdminExists(email, password);
    }

    @Override
    public boolean isStudentExists(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            LOGGER.info("Email or password is empty");
            throw new InvalidDataRuntimeException("Email or password is empty");
        }
        return userDao.isStudentExists(email, password);
    }

    @Override
    public boolean isTeacherExists(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            LOGGER.info("Email or password is empty");
            throw new InvalidDataRuntimeException("Email or password is empty");
        }
        return userDao.isTeacherExists(email, password);
    }

}
