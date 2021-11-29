package com.example.faculty.model.enums;

import java.util.ArrayList;
import java.util.List;

public enum CourseStatus {
    NOT_STARTED("Not started"),
    STARTED("Started"),
    IN_PROGRESS("In progress"),
    FINISH("Finish");

    public final String courseStatusName;

    CourseStatus(String courseStatusName) {
        this.courseStatusName = courseStatusName;
    }

    public static List<CourseStatus> allStatuses() {
        List<CourseStatus> statuses = new ArrayList<>();
        statuses.add(CourseStatus.NOT_STARTED);
        statuses.add(CourseStatus.STARTED);
        statuses.add(CourseStatus.IN_PROGRESS);
        statuses.add(CourseStatus.FINISH);
        return statuses;
    }

}
