package com.example.faculty.controller.command.account.admin.courses;

import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;
import com.example.faculty.dao.interf.StudentMarkDao;
import com.example.faculty.model.adapter.CourseDto;
import com.example.faculty.model.adapter.CourseDtoAdapter;
import com.example.faculty.model.domain.Course;
import com.example.faculty.model.domain.StudentMark;
import com.example.faculty.service.interf.CourseService;
import com.example.faculty.service.interf.TopicService;
import com.example.faculty.service.interf.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CourseInfoCommand implements Command {

    private final Logger LOGGER = Logger.getLogger(CourseInfoCommand.class);

    private TopicService topicService;
    private UserService userService;
    private CourseService courseService;
    private StudentMarkDao studentMarkDao;

    public CourseInfoCommand(TopicService topicService, UserService userService, CourseService courseService,
                             StudentMarkDao studentMarkDao) {
        this.topicService = topicService;
        this.userService = userService;
        this.courseService = courseService;
        this.studentMarkDao = studentMarkDao;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        LOGGER.info("course info");
        Long courseId = Long.parseLong(request.getParameter("course"));

        Course course = courseService.findById(courseId);
        CourseDto courseDto = new CourseDtoAdapter(topicService, userService).adapterCourse(course);
        request.setAttribute("course", courseDto);

        List<StudentMark> studentsMark = studentMarkDao.findAllStudentsMark(courseId);
        request.setAttribute("studentsMark", studentsMark);

        return RoutesJSP.COURSE_INFO;
    }
}
