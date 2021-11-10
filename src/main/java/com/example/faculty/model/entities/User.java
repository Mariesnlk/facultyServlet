package com.example.faculty.model.entities;

import com.example.faculty.model.enums.UserRole;

import java.util.Objects;

public class User {

    public Long userId;

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


    public class Builder {

        public User.Builder setFirstName(String firstName) {
            User.this.firstName = firstName;
            return this;
        }

        public User.Builder setSecondName(String secondName) {
            User.this.secondName = secondName;
            return this;
        }

        public User.Builder setLastName(String lastName) {
            User.this.lastName = lastName;
            return this;
        }

        public User.Builder setEmail(String email) {
            User.this.email = email;
            return this;
        }


        public User.Builder setPassword(String password) {
            User.this.password = password;
            return this;
        }

        public User.Builder setRole(UserRole role) {
            User.this.role = role;
            return this;
        }

        public User build() {
            return User.this;
        }

    }

}
