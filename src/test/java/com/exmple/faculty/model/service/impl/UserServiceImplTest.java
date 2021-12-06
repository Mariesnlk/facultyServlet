package com.exmple.faculty.model.service.impl;

import com.example.faculty.cipher.AES;
import com.example.faculty.dao.interf.UserDao;
import com.example.faculty.exception.EmailIsAlreadyTaken;
import com.example.faculty.exception.InputDataInCorrectRuntimeException;
import com.example.faculty.exception.InvalidDataRuntimeException;
import com.example.faculty.model.domain.User;
import com.example.faculty.model.entity.UserEntity;
import com.example.faculty.model.enums.UserRole;
import com.example.faculty.model.mapper.UserMapper;
import com.example.faculty.service.impl.UserServiceImpl;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    private static final UserEntity USER_ENTITY = getUserEntity();
    private static final User USER = getUser();
    private static final boolean USER_EXIST = true;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Mock
    private UserDao dao;

    @Mock
    private UserMapper mapper;

    @After
    public void resetMock() {
        reset(dao, mapper);
    }

    @InjectMocks
    private UserServiceImpl service;

    @Test
    public void createUserInDatabaseShouldReturnUser() {
        when(dao.isEmailExists(anyString())).thenReturn(false);
        when(mapper.userToUserEntity(any(User.class))).thenReturn(USER_ENTITY);

        service.create(USER);

        verify(dao).create(any(UserEntity.class));
    }

    @Test
    public void createUserInDatabaseShouldThrowEmailIsAlreadyTaken() {
        when(dao.isEmailExists(anyString())).thenReturn(true);
        exception.expect(EmailIsAlreadyTaken.class);
        exception.expectMessage("This email is already registered");

        service.create(USER);
    }

    @Test
    public void createUserInDatabaseShouldThrowInvalidDataRuntimeExceptionWithEmptyParams() {
        exception.expect(InputDataInCorrectRuntimeException.class);
        exception.expectMessage("User is empty");

        service.create(null);
    }

    @Test
    public void isUserAlreadyExistShouldReturnTrueWithExistUser() {
        when(dao.isStudentExists(anyString(), anyString())).thenReturn(USER_EXIST);

        boolean actual = service.isStudentExists("user@gmail.com", "phbnEaOHifKbK72SUcQjXA==");

        assertThat(actual, is(USER_EXIST));
    }

    @Test
    public void isUserAlreadyExistShouldThrowInvalidDataRuntimeExceptionWithEmptyParams() {
        exception.expect(InvalidDataRuntimeException.class);
        exception.expectMessage("Email or password is empty");

        service.isStudentExists("", "");
    }

    @Test
    public void getUserByEmailAndPasswordShouldReturnUser() {
        when(dao.findUserByEmailAndPass(anyString(), anyString())).thenReturn(Optional.ofNullable(USER_ENTITY));
        when(mapper.userEntityToUser(any(UserEntity.class))).thenReturn(USER);

        User actual = service.getUserByEmailAndPassword("user@gmail.com", "phbnEaOHifKbK72SUcQjXA==");

        assertThat(actual, is(USER));
    }


    @Test
    public void getUserByEmailAndPasswordShouldThrowInputDataUnCorrectRuntimeExceptionWithEmptyParams() {
        exception.expect(InputDataInCorrectRuntimeException.class);
        exception.expectMessage("User email and password must be not null");

        service.getUserByEmailAndPassword("", "");
    }

    private static UserEntity getUserEntity() {

        return new UserEntity.Builder()
                .setUserId(1L)
                .setDate(new Date())
                .setFirstName("Anna")
                .setSecondName("Mariia")
                .setLastName("Synelnyk")
                .setEmail("user@gmail.com")
                .setPassword(AES.decrypt("user123!", AES.KEY))
                .setRole(UserRole.STUDENT)
                .build();
    }

    private static User getUser() {
        return new User.Builder()
                .setUserId(1L)
                .setDate(new Date())
                .setFirstName("Anna")
                .setSecondName("Mariia")
                .setLastName("Synelnyk")
                .setEmail("user@gmail.com")
                .setPassword(AES.decrypt("user123!", AES.KEY))
                .setRole(UserRole.STUDENT)
                .build();
    }
}
