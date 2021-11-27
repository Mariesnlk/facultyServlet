package com.exmple.faculty.model.mapper;

import com.example.faculty.cipher.AES;
import com.example.faculty.model.domain.User;
import com.example.faculty.model.entity.UserEntity;
import com.example.faculty.model.enums.UserRole;
import com.example.faculty.model.mapper.UserMapper;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserMapperTest {
    private static final UserEntity USER_ENTITY = getUserEntity();

    private static final User USER = getUser();

    private final UserMapper userMapper = new UserMapper();

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


    @Test
    public void shouldMapUserEntityToUser() {
        User user = userMapper.userEntityToUser(USER_ENTITY);

        assertThat(user.getUserId(), is(USER.getUserId()));
        assertThat(user.getFirstName(), is(USER.getFirstName()));
        assertThat(user.getSecondName(), is(USER.getSecondName()));
        assertThat(user.getLastName(), is(USER.getLastName()));
        assertThat(user.getEmail(), is(USER.getEmail()));
        assertThat(user.getPassword(), is(USER.getPassword()));
        assertThat(user.getRole(), is(USER.getRole()));
    }

    @Test
    public void shouldMapUserToUserEntity() {
        UserEntity userEntity = userMapper.userToUserEntity(USER);

        assertThat(userEntity.getUserId(), is(USER_ENTITY.getUserId()));
        assertThat(userEntity.getFirstName(), is(USER_ENTITY.getFirstName()));
        assertThat(userEntity.getSecondName(), is(USER_ENTITY.getSecondName()));
        assertThat(userEntity.getLastName(), is(USER_ENTITY.getLastName()));
        assertThat(userEntity.getEmail(), is(USER_ENTITY.getEmail()));
        assertThat(userEntity.getPassword(), is(USER_ENTITY.getPassword()));
        assertThat(userEntity.getRole(), is(USER_ENTITY.getRole()));

    }

    @Test
    public void shouldMapUserToUserEntityWithoutId() {
        UserEntity userEntity = userMapper.userToUserEntityWithoutId(USER);

        assertThat(userEntity.getFirstName(), is(USER_ENTITY.getFirstName()));
        assertThat(userEntity.getSecondName(), is(USER_ENTITY.getSecondName()));
        assertThat(userEntity.getLastName(), is(USER_ENTITY.getLastName()));
        assertThat(userEntity.getEmail(), is(USER_ENTITY.getEmail()));
        assertThat(userEntity.getPassword(), is(USER_ENTITY.getPassword()));
        assertThat(userEntity.getRole(), is(USER_ENTITY.getRole()));

    }

    @Test
    public void mapUserToUserEntityShouldReturnNull() {
        UserEntity userEntity = userMapper.userToUserEntity(null);
        assertThat(userEntity, is(nullValue()));
    }

    @Test
    public void mapUserEntityToUserShouldReturnNull() {
        User user = userMapper.userEntityToUser(null);
        assertThat(user, is(nullValue()));
    }

    @Test
    public void mapUserToUserEntityWithoutIdShouldReturnNull() {
        UserEntity userEntity = userMapper.userToUserEntityWithoutId(null);
        assertThat(userEntity, is(nullValue()));
    }

}
