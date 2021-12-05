package com.example.faculty.controller.command.common;

import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;
import com.example.faculty.controller.command.account.admin.user.ShowAllTeachersCommand;
import com.example.faculty.model.adapter.CourseDto;
import com.example.faculty.model.adapter.CourseDtoAdapter;
import com.example.faculty.model.domain.Course;
import com.example.faculty.service.interf.CourseService;
import com.example.faculty.service.interf.TopicService;
import com.example.faculty.service.interf.UserService;
import com.example.faculty.utils.PageUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowAllCoursesCommand implements Command {

    private final Logger LOGGER = Logger.getLogger(ShowAllTeachersCommand.class);

    private CourseService courseService;
    private TopicService topicService;
    private UserService userService;

    public ShowAllCoursesCommand(CourseService courseService, TopicService topicService, UserService userService) {
        this.courseService = courseService;
        this.topicService = topicService;
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.info("ShowAllCoursesCommand");
        int pageNumber;
        int totalNumberRecords = (int) courseService.getAllCoursesCount();
        int recordPerPage = 5;
        int startIndex;
        int numberOfPages;

        String sPageNo = request.getParameter("pagination");

        pageNumber = PageUtils.getPageNumber(sPageNo);
        startIndex = (pageNumber * recordPerPage) - recordPerPage;
        List<Course> coursesList = courseService.getAllCourses(startIndex, recordPerPage);
        CourseDtoAdapter courseAdapter = new CourseDtoAdapter(topicService, userService);
        List<CourseDto> adapterList = courseAdapter.coursesListAdapter(coursesList);

        request.setAttribute("coursesList", adapterList);
        request.setAttribute("recordPerPage", recordPerPage);
        numberOfPages = totalNumberRecords / recordPerPage;
        if (totalNumberRecords > numberOfPages * recordPerPage) {
            numberOfPages = numberOfPages + 1;
        }

        request.setAttribute("pageNumbers", numberOfPages);
        return RoutesJSP.ALL_COURSES;
    }

}
