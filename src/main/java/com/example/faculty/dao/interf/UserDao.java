package com.example.faculty.dao.interf;

import com.example.faculty.model.entity.UserEntity;
import com.example.faculty.model.enums.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserDao extends CrudDao<UserEntity, Long> {

    boolean isEmailExists(String email);

    UserEntity getUserByEmail(String email);

    List<UserEntity> findAllByUserRoleNameOrderByCreatedDate(UserRole userRoleName);

    boolean isStudentExists(String email, String password);

    boolean isTeacherExists(String email, String password);

    boolean isAdminExists(String email, String password);

    Optional<UserEntity> findUserByEmailAndPass(String email, String password);
}