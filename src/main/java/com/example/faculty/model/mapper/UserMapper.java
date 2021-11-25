package com.example.faculty.model.mapper;

import com.example.faculty.model.domain.User;
import com.example.faculty.model.entity.UserEntity;

public class UserMapper {

    public User userEntityToUser(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }

        return new User.Builder()
                .setUserId(userEntity.getUserId())
                .setFirstName(userEntity.getFirstName())
                .setSecondName(userEntity.getSecondName())
                .setLastName(userEntity.getLastName())
                .setEmail(userEntity.getEmail())
                .setPassword(userEntity.getPassword())
                .setRole(userEntity.getRole())
                .build();
    }

    public UserEntity userToUserEntity(User user) {
        if (user == null) {
            return null;
        }

        return new UserEntity.Builder()
                .setUserId(user.getUserId())
                .setFirstName(user.getFirstName())
                .setSecondName(user.getSecondName())
                .setLastName(user.getLastName())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setRole(user.getRole())
                .build();
    }

    public UserEntity userToUserEntityWithoutId(User user) {
        if (user == null) {
            return null;
        }

        return new UserEntity.Builder()
                .setDate(user.getDate())
                .setFirstName(user.getFirstName())
                .setSecondName(user.getSecondName())
                .setLastName(user.getLastName())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setRole(user.getRole())
                .build();
    }
}
