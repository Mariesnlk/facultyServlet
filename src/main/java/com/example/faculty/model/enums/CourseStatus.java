package com.example.faculty.model.enums;

public enum CourseStatus {
    NOT_STARTED("Not started"),
    STARTED("Started"),
    IN_PROGRESS("In progress"),
    FINISH("Finish");

    public final String courseStatusName;

    CourseStatus(String courseStatusName) {
        this.courseStatusName = courseStatusName;
    }

}
