package com.example.faculty.controller.command.account.admin.courses;

import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;
import com.example.faculty.model.domain.Course;
import com.example.faculty.model.enums.CourseStatus;
import com.example.faculty.service.interf.CourseService;
import com.example.faculty.service.interf.TopicService;
import com.example.faculty.service.interf.UserService;
import com.example.faculty.utils.InputDataValidationUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static com.example.faculty.controller.command.PathCommand.ALL_COURSES_PAG;
import static com.example.faculty.controller.command.RoutesJSP.REDIRECT;

public class UpdateCourses implements Command {

    private final Logger LOGGER = Logger.getLogger(UpdateCourses.class);

    private TopicService topicService;
    private UserService userService;
    private CourseService courseService;

    public UpdateCourses(TopicService topicService, UserService userService, CourseService courseService) {

        this.topicService = topicService;
        this.userService = userService;
        this.courseService = courseService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.info("start update course");
        final String courseId = request.getParameter("course");

        final String topicId = request.getParameter("topic");
        final String teacherId = request.getParameter("teacher");
        final String status = request.getParameter("status");
        final String courseName = request.getParameter("name");
        final String studentsAmount = request.getParameter("studentsAmount");
        final String duration = request.getParameter("duration");

        if (!(InputDataValidationUtils.isNullOrEmpty(topicId) && InputDataValidationUtils.isNullOrEmpty(teacherId)
                && InputDataValidationUtils.isNullOrEmpty(status) && InputDataValidationUtils.isNullOrEmpty(courseName)
                && InputDataValidationUtils.isNullOrEmpty(studentsAmount) && InputDataValidationUtils.isNullOrEmpty(duration))) {
            if (InputDataValidationUtils.isCorrectName(courseName)) {

                Course courseToUpdate = courseService.findById(Long.parseLong(courseId));
                courseToUpdate.setDate(new Date());
                courseToUpdate.setTopic(Long.parseLong(topicId));
                courseToUpdate.setTeacher(Long.parseLong(teacherId));
                courseToUpdate.setCourseName(courseName);
                courseToUpdate.setDuration(Integer.parseInt(duration));
                courseToUpdate.setEnrollStudents(courseToUpdate.getEnrollStudents());
                courseToUpdate.setStatus(CourseStatus.valueOf(status));

                courseService.update(courseToUpdate);


                LOGGER.info("created");
                String contextAndServletPath = request.getContextPath() + request.getServletPath();
                return REDIRECT + contextAndServletPath + ALL_COURSES_PAG + "?pagination=1";
            } else {
                return RoutesJSP.ADD_TOPIC + "?notValid=true";
            }
        } else {
            return RoutesJSP.ADD_COURSE + "?badInput=true";
        }
    }
}
