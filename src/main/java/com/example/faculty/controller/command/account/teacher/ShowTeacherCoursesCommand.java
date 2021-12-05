package com.example.faculty.controller.command.account.teacher;

import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;
import com.example.faculty.model.domain.Course;
import com.example.faculty.model.domain.User;
import com.example.faculty.service.interf.CourseService;
import com.example.faculty.service.interf.TopicService;
import com.example.faculty.service.interf.UserService;
import com.example.faculty.utils.LoginUserUtils;
import com.example.faculty.utils.PageUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowTeacherCoursesCommand implements Command {

    private final Logger LOGGER = Logger.getLogger(ShowTeacherCoursesCommand.class);

    private CourseService courseService;
    private TopicService topicService;
    private UserService userService;

    public ShowTeacherCoursesCommand(CourseService courseService) {
        this.courseService = courseService;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.info("ShowTeacherCoursesCommand");

        Long teacherId = (LoginUserUtils.getLoginUser(request.getSession())).getUserId();

        int pageNumber;
        int totalNumberRecords = (int) courseService.getAllTeachersCoursesCount(teacherId);
        int recordPerPage = 5;
        int startIndex;
        int numberOfPages;

        String sPageNo = request.getParameter("pagination");

        pageNumber = PageUtils.getPageNumber(sPageNo);
        startIndex = (pageNumber * recordPerPage) - recordPerPage;
        List<Course> coursesList = courseService.getAllTeachersCourses(startIndex, recordPerPage, teacherId);
//        CourseDtoAdapter courseAdapter = new CourseDtoAdapter(topicService, userService);
//        List<CourseDto> adapterList = courseAdapter.coursesListAdapter(coursesList);

        request.setAttribute("coursesList", coursesList);
        request.setAttribute("recordPerPage", recordPerPage);
        numberOfPages = totalNumberRecords / recordPerPage;
        if (totalNumberRecords > numberOfPages * recordPerPage) {
            numberOfPages = numberOfPages + 1;
        }

        request.setAttribute("pageNumbers", numberOfPages);
        return RoutesJSP.TEACHER_COURSES;
    }

}
