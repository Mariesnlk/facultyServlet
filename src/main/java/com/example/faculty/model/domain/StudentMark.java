package com.example.faculty.model.domain;

public class StudentMark {

    private Long id;
    private String firstName;
    private String secondName;
    private String lastName;
    private Integer mark;

    public StudentMark() {
    }

    public StudentMark(Long id, String firstName, String secondName, String lastName, Integer mark) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.mark = mark;
    }

    public Long getId() {
        return id;
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

    public Integer getMark() {
        return mark;
    }

    public static class Builder {

        private StudentMark studentMark;

        public Builder() {
            studentMark = new StudentMark();
        }

        public Builder setId(Long userId) {
            studentMark.id = userId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            studentMark.firstName = firstName;
            return this;
        }

        public Builder setSecondName(String secondName) {
            studentMark.secondName = secondName;
            return this;
        }

        public Builder setLastName(String lastName) {
            studentMark.lastName = lastName;
            return this;
        }

        public Builder setMark(Integer mark) {
            studentMark.mark = mark;
            return this;
        }

        public StudentMark build() {
            return studentMark;
        }

    }
}
