package com.example.faculty.controller.command.account.student;

import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;
import com.example.faculty.dao.interf.CourseWithMyMarkDao;
import com.example.faculty.model.adapter.CourseWithMarkDto;
import com.example.faculty.model.adapter.CourseWithMarkDtoAdapter;
import com.example.faculty.model.domain.CoursesWithMyMark;
import com.example.faculty.service.interf.TopicService;
import com.example.faculty.service.interf.UserService;
import com.example.faculty.utils.LoginUserUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentCoursesCommand implements Command {

    private final Logger LOGGER = Logger.getLogger(StudentCoursesCommand.class);

    private CourseWithMyMarkDao courseWithMyMarkDao;
    private TopicService topicService;
    private UserService userService;

    public StudentCoursesCommand(CourseWithMyMarkDao courseWithMyMarkDao, TopicService topicService,
                                 UserService userService) {
        this.courseWithMyMarkDao = courseWithMyMarkDao;
        this.topicService = topicService;
        this.userService = userService;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Long studentId = (LoginUserUtils.getLoginUser(request.getSession())).getUserId();
        List<CoursesWithMyMark> courses = courseWithMyMarkDao.findAllStudentCourses(studentId);

        List<CourseWithMarkDto> adaptedCourses = new CourseWithMarkDtoAdapter(topicService, userService).coursesListAdapter(courses);

        request.setAttribute("courses", adaptedCourses);

        return RoutesJSP.STUDENT_COURSES;
    }
}
