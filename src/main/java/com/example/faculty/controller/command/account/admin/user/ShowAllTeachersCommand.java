package com.example.faculty.controller.command.account.admin.user;

import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;
import com.example.faculty.model.domain.Topic;
import com.example.faculty.model.domain.User;
import com.example.faculty.service.interf.UserService;
import com.example.faculty.utils.PageUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowAllTeachersCommand implements Command {

    private final Logger LOGGER = Logger.getLogger(ShowAllTeachersCommand.class);

    private UserService userService;

    public ShowAllTeachersCommand(UserService userService) {
        this.userService = userService;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.info("ShowAllTeachersCommand");
        int pageNumber;
        int totalNumberRecords = (int) userService.getAllTeachersCount();
        int recordPerPage = 5;
        int startIndex;
        int numberOfPages;

        String sPageNo = request.getParameter("pagination");

        pageNumber = PageUtils.getPageNumber(sPageNo);
        startIndex = (pageNumber * recordPerPage) - recordPerPage;
        List<User> teachersList = userService.getAllTeachers(startIndex, recordPerPage);

        request.setAttribute("teachersList", teachersList);
        request.setAttribute("recordPerPage", recordPerPage);
        numberOfPages = totalNumberRecords / recordPerPage;
        if (totalNumberRecords > numberOfPages * recordPerPage) {
            numberOfPages = numberOfPages + 1;
        }

        request.setAttribute("pageNumbers", numberOfPages);
        return RoutesJSP.ALL_TEACHERS;
    }
}
