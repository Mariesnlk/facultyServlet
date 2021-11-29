package com.example.faculty.controller.command.account.admin.courses;

import com.example.faculty.controller.command.Command;
import com.example.faculty.service.interf.CourseService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.faculty.controller.command.PathCommand.ALL_COURSES_PAG;
import static com.example.faculty.controller.command.PathCommand.ALL_TOPICS_PAG;
import static com.example.faculty.controller.command.RoutesJSP.REDIRECT;

public class DeleteCourse implements Command {

    private final Logger LOGGER = Logger.getLogger(DeleteCourse.class);

    private CourseService courseService;

    public DeleteCourse(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String courseId = request.getParameter("course");

        courseService.delete(courseService.findById(Long.valueOf(courseId)));

        String contextAndServletPath = request.getContextPath() + request.getServletPath();
        return REDIRECT + contextAndServletPath + ALL_COURSES_PAG + "?pagination=1";
    }
}
