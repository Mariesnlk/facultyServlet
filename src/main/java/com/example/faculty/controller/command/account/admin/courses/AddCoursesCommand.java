package com.example.faculty.controller.command.account.admin.courses;

import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;
import com.example.faculty.model.domain.Topic;
import com.example.faculty.model.domain.User;
import com.example.faculty.model.enums.CourseStatus;
import com.example.faculty.service.interf.TopicService;
import com.example.faculty.service.interf.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddCoursesCommand implements Command {

    private final Logger LOGGER = Logger.getLogger(AddCoursesCommand.class);

    private TopicService topicService;
    private UserService userService;

    public AddCoursesCommand(TopicService topicService, UserService userService) {

        this.topicService = topicService;
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.info("add course");
        List<Topic> topicsList = topicService.getAllTopics();
        request.setAttribute("topicsList", topicsList);
        List<User> teachersList = userService.allTeachers();
        request.setAttribute("teachersList", teachersList);
        List<CourseStatus> statuses = CourseStatus.allStatuses();
        request.setAttribute("statuses", statuses);

        return RoutesJSP.ADD_COURSE;
    }
}
