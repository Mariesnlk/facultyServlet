package com.example.faculty.service.interf;

import com.example.faculty.model.domain.User;

import java.util.List;

public interface UserService extends CrudService<User, Long> {

    User findByEmail(String email);

    void updatePassword(User user, String newPassword);

//    Paged getStudentsPage(int pageNumber, int size);
//
//    Paged getTeachersPage(int pageNumber, int size);

    List<User> allTeachers();

    User getUserByEmailAndPassword(String email, String hashPassword);

    boolean isAdminExists(String email, String password);

    boolean isStudentExists(String email, String password);

    boolean isTeacherExists(String email, String password);

//    Paged findAllStudentsByIdCourse(Long courseId, int pageNumber, int size);


}

