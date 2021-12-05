package com.example.faculty.controller.command.account.student;

import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;
import com.example.faculty.dao.interf.CourseWithMyMarkDao;
import com.example.faculty.model.domain.CoursesWithMyMark;
import com.example.faculty.model.domain.Topic;
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

    public StudentCoursesCommand(CourseWithMyMarkDao courseWithMyMarkDao) {
        this.courseWithMyMarkDao = courseWithMyMarkDao;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Long studentId = (LoginUserUtils.getLoginUser(request.getSession())).getUserId();
        List<CoursesWithMyMark> courses = courseWithMyMarkDao.findAllStudentCourses(studentId);

        request.setAttribute("courses", courses);

        return RoutesJSP.STUDENT_COURSES;
    }
}
