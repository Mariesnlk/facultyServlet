package com.example.faculty.dao.interf;

import com.example.faculty.model.entity.UserEntity;
import com.example.faculty.model.enums.UserRole;

import java.util.List;

public interface UserDao extends CrudDao<UserEntity, Long> {

    UserEntity getUserByEmail(String email);

    List<UserEntity> findAllByUserRoleNameOrderByCreatedDate(UserRole userRoleName);

//    Page<User> getAllByUserRoleNameOrderByCreatedDate(String userRoleName, Pageable pageable);
//
//    @Query("select u.firstName, u.secondName, u.lastName, g.mark " +
//            "from User u " +
//            "left join Enroll e " +
//            "on u.id = e.idUser " +
//            "left join GradeBook g " +
//            "on g.idStudent = e.idUser " +
//            "where e.idCourse=:courseId")
//    Page<User> findAllStudentsByIdCourse(@Param("courseId") Long courseId, Pageable pageable);

}