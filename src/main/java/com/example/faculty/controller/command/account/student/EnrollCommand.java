package com.example.faculty.controller.command.account.student;

import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;
import com.example.faculty.model.adapter.CourseDto;
import com.example.faculty.model.adapter.CourseDtoAdapter;
import com.example.faculty.model.domain.Course;
import com.example.faculty.service.interf.CourseService;
import com.example.faculty.service.interf.EnrollService;
import com.example.faculty.service.interf.TopicService;
import com.example.faculty.service.interf.UserService;
import com.example.faculty.utils.LoginUserUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EnrollCommand implements Command {

    private final Logger LOGGER = Logger.getLogger(EnrollCommand.class);

    private final EnrollService enrollService;
    private final CourseService courseService;
    private final TopicService topicService;
    private final UserService userService;

    public EnrollCommand(EnrollService enrollService, CourseService courseService,
                         TopicService topicService, UserService userService) {
        this.enrollService = enrollService;
        this.courseService = courseService;
        this.topicService = topicService;
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.info("enroll to course");

        String courseId = request.getParameter("course");
        Long userId = (LoginUserUtils.getLoginUser(request.getSession())).getUserId();

        boolean isEnroll = enrollService.enroll(userId, Long.parseLong(courseId));
        request.setAttribute("isEnroll", isEnroll);

        courseService.increaseCountOfEnrollStudents(Long.parseLong(courseId));

        int pageNumber;
        int totalNumberRecords = (int) courseService.getAllCoursesCount();
        int recordPerPage = 5;
        int startIndex;
        int numberOfPages;

        String sPageNo = request.getParameter("pagination");

        pageNumber = getPageNumber(sPageNo);
        startIndex = (pageNumber * recordPerPage) - recordPerPage;
        List<Course> coursesList = courseService.getAllCourses(startIndex, recordPerPage);
        List<CourseDto> adapterList = new CourseDtoAdapter(topicService, userService).coursesListAdapter(coursesList);

        request.setAttribute("coursesList", adapterList);
        request.setAttribute("recordPerPage", recordPerPage);
        numberOfPages = totalNumberRecords / recordPerPage;
        if (totalNumberRecords > numberOfPages * recordPerPage) {
            numberOfPages = numberOfPages + 1;
        }

        request.setAttribute("pageNumbers", numberOfPages);
        return RoutesJSP.ALL_COURSES;
    }

    private int getPageNumber(String strNumber) {
        try {
            return Integer.parseInt(strNumber);
        } catch (IllegalArgumentException e) {
            return 1;
        }
    }
}
