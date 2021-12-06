package com.exmple.faculty.model.dao.impl;

import com.example.faculty.cipher.AES;
import com.example.faculty.dao.impl.UserDaoImpl;
import com.example.faculty.database.DBHelper;
import com.example.faculty.model.entity.UserEntity;
import com.example.faculty.model.enums.UserRole;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class UserDaoImplTest {

    private static final DBHelper CONNECTOR = new DBHelper();

    private UserDaoImpl userDao = new UserDaoImpl(CONNECTOR);

    @Test
    public void create() throws SQLException {
        userDao.create(new UserEntity.Builder()
                .setUserId(6L)
                .setDate(new Date())
                .setFirstName("Andriy")
                .setSecondName("Alex")
                .setLastName("Gais")
                .setEmail("gais123@gmail.com")
                .setPassword(AES.encrypt("password123!", AES.KEY))
                .setRole(UserRole.STUDENT)
                .build());

        UserEntity user = userDao.findById(6L);

        assertThat(user.getUserId(), equalTo(6L));
        assertThat(user.getFirstName(), equalTo("Andriy"));
        assertThat(user.getSecondName(), equalTo("Alex"));
        assertThat(user.getLastName(), equalTo("Gais"));
        assertThat(user.getEmail(), equalTo("gais123@gmail.com"));
        assertThat(user.getPassword(), equalTo("N6TlHH6d5eRC+C7TU4N+aQ=="));
        assertThat(user.getRole(), equalTo(UserRole.STUDENT));
    }

    @Test
    public void findById() throws SQLException {
        UserEntity user = userDao.findById(1L);

        assertThat(user.getUserId(), equalTo(1L));
        assertThat(user.getFirstName(), equalTo("Emma"));
        assertThat(user.getSecondName(), equalTo("Em"));
        assertThat(user.getLastName(), equalTo("Synelnyk"));
        assertThat(user.getEmail(), equalTo("admin@gmail.com"));
        assertThat(user.getPassword(), equalTo("V5KmS3fu1mR5i+eRNaVi5w=="));
        assertThat(user.getRole(), equalTo(UserRole.ADMINISTRATOR));
    }

    @Test
    public void update() throws SQLException {
        UserEntity user = userDao.findById(6L);
        user.setDate(new Date());
        user.setFirstName("Olga");
        user.setSecondName("Bogdanivna");
        user.setLastName("Nester");
        user.setEmail("olga.nester@gmail.com");
        user.setPassword(user.getPassword());
        user.setRole(user.getRole());
        user.setUserId(user.getUserId());
        userDao.update(user);

        UserEntity updatedUser = userDao.findById(6L);
        assertThat(updatedUser.getUserId(), equalTo(6L));
        assertThat(updatedUser.getFirstName(), equalTo("Olga"));
        assertThat(updatedUser.getSecondName(), equalTo("Bogdanivna"));
        assertThat(updatedUser.getLastName(), equalTo("Nester"));
        assertThat(updatedUser.getEmail(), equalTo("olga.nester@gmail.com"));
        assertThat(updatedUser.getPassword(), equalTo("N6TlHH6d5eRC+C7TU4N+aQ=="));
        assertThat(updatedUser.getRole(), equalTo(UserRole.STUDENT));
    }


    @Test
    public void findAll() throws SQLException {
        List<UserEntity> users = userDao.findAll();
        assertThat(users, hasSize(6));
        UserEntity user = users.get(5);
        assertThat(user.getUserId(), equalTo(6L));
        assertThat(user.getFirstName(), equalTo("Olga"));
        assertThat(user.getSecondName(), equalTo("Bogdanivna"));
        assertThat(user.getLastName(), equalTo("Nester"));
        assertThat(user.getEmail(), equalTo("olga.nester@gmail.com"));
        assertThat(user.getPassword(), equalTo("N6TlHH6d5eRC+C7TU4N+aQ=="));
        assertThat(user.getRole(), equalTo(UserRole.STUDENT));
    }

    @Test
    public void isEmailExist() throws SQLException {
        assertTrue(userDao.isEmailExists("olga.nester@gmail.com"));
        assertFalse(userDao.isEmailExists("false@gmail.com"));
    }

    @Test
    public void getUserByEmail() throws SQLException {
        UserEntity user = userDao.getUserByEmail("admin@gmail.com");

        assertThat(user.getUserId(), equalTo(1L));
        assertThat(user.getFirstName(), equalTo("Emma"));
        assertThat(user.getSecondName(), equalTo("Em"));
        assertThat(user.getLastName(), equalTo("Synelnyk"));
        assertThat(user.getEmail(), equalTo("admin@gmail.com"));
        assertThat(user.getPassword(), equalTo("V5KmS3fu1mR5i+eRNaVi5w=="));
        assertThat(user.getRole(), equalTo(UserRole.ADMINISTRATOR));
    }

    @Test
    public void isStudentExist() throws SQLException {
        assertTrue(userDao.isStudentExists("olga.nester@gmail.com", "N6TlHH6d5eRC+C7TU4N+aQ=="));
        assertFalse(userDao.isStudentExists("admin@gmail.com", "V5KmS3fu1mR5i+eRNaVi5w=="));
    }

    @Test
    public void isTeacherExist() throws SQLException {
        assertTrue(userDao.isTeacherExists("juli.synelnyk@gmail.com", "V5KmS3fu1mR5i+eRNaVi5w=="));
        assertFalse(userDao.isTeacherExists("admin@gmail.com", "V5KmS3fu1mR5i+eRNaVi5w=="));
    }

    @Test
    public void iAdminExist() throws SQLException {
        assertFalse(userDao.isAdminExists("olga.nester@gmail.com", "N6TlHH6d5eRC+C7TU4N+aQ=="));
        assertTrue(userDao.isAdminExists("admin@gmail.com", "V5KmS3fu1mR5i+eRNaVi5w=="));
    }

    @Test
    public void findUserByEmailAndPass() throws SQLException {
        assertTrue(userDao.findUserByEmailAndPass("admin@gmail.com","V5KmS3fu1mR5i+eRNaVi5w==" ).isPresent());
        assertEquals(userDao.findUserByEmailAndPass("admin@gmail.com","V5KmS3fu1mR5i+eRNaVi5w==" ).get(),
                userDao.findById(1L));

    }

    @Test
    public void findCount() throws SQLException {
        assertEquals(userDao.findCountStudents(), 3L);
        assertEquals(userDao.findCountTeachers(), 2L);

    }
}
