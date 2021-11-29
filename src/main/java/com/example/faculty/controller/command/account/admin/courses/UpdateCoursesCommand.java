package com.example.faculty.controller.command.account.admin.courses;

import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;
import com.example.faculty.model.domain.Course;
import com.example.faculty.model.domain.Topic;
import com.example.faculty.model.domain.User;
import com.example.faculty.model.enums.CourseStatus;
import com.example.faculty.service.interf.CourseService;
import com.example.faculty.service.interf.TopicService;
import com.example.faculty.service.interf.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UpdateCoursesCommand implements Command {

    private final Logger LOGGER = Logger.getLogger(UpdateCoursesCommand.class);

    private TopicService topicService;
    private UserService userService;
    private CourseService courseService;

    public UpdateCoursesCommand(TopicService topicService, UserService userService, CourseService courseService) {

        this.topicService = topicService;
        this.userService = userService;
        this.courseService = courseService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.info("update course");

        String courseId = request.getParameter("course");

        Course course = courseService.findById(Long.valueOf(courseId));
        request.setAttribute("course", course);
        LOGGER.info(course);

        List<Topic> topicsList = topicService.getAllTopics();
        request.setAttribute("topicsList", topicsList);
        List<User> teachersList = userService.allTeachers();
        request.setAttribute("teachersList", teachersList);
        List<CourseStatus> statuses = CourseStatus.allStatuses();
        request.setAttribute("statuses", statuses);

        return RoutesJSP.UPDATE_COURSES;
    }
}
