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

    Optional<UserEntity> findTeacherByEmail(String email);

    long findCountStudents();

    List<UserEntity> findAllStudents(int row, int limit);

    long findCountTeachers();

    List<UserEntity> findAllTeachers(int row, int limit);

    List<UserEntity> findAllTeachers();

    boolean isTeacherWithEmailExists(String email);

    void updatePassword(UserEntity userEntity);
}