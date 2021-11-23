package com.example.faculty.model.domain;

import com.example.faculty.model.enums.UserRole;

import java.util.Date;
import java.util.Objects;

public class User {

    public Long userId;

    // TODO: 22.11.2021 add date 
    private Date date;

    public String firstName;

    public String secondName;

    public String lastName;

    public String email;

    public String password;

    public UserRole role;



    public Long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, role);
    }



    public static class Builder {

        private User newUser;

        public Builder() {
            newUser = new User();
        }

        public Builder setUserId(Long userId) {
            newUser.userId = userId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            newUser.firstName = firstName;
            return this;
        }

        public Builder setSecondName(String secondName) {
            newUser.secondName = secondName;
            return this;
        }

        public Builder setLastName(String lastName) {
            newUser.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            newUser.email = email;
            return this;
        }


        public Builder setPassword(String password) {
            newUser.password = password;
            return this;
        }

        public Builder setRole(UserRole role) {
            newUser.role = role;
            return this;
        }

        public User build() {
            return newUser;
        }

    }

}
