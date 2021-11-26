package com.example.faculty.controller.command.account.admin.user;

import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;
import com.example.faculty.model.domain.User;
import com.example.faculty.service.interf.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowAllStudentsCommand implements Command {

    private final Logger LOGGER = Logger.getLogger(ShowAllStudentsCommand.class);

    private UserService userService;

    public ShowAllStudentsCommand(UserService userService) {
        this.userService = userService;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.info("ShowAllStudentsCommand");
        int pageNumber;
        int totalNumberRecords = (int) userService.getAllStudentsCount();
        int recordPerPage = 5;
        int startIndex;
        int numberOfPages;

        String sPageNo = request.getParameter("pagination");

        pageNumber = getPageNumber(sPageNo);
        startIndex = (pageNumber * recordPerPage) - recordPerPage;
        List<User> studentsList = userService.getAllStudents(startIndex, recordPerPage);

        request.setAttribute("studentsList", studentsList);
        request.setAttribute("recordPerPage", recordPerPage);
        numberOfPages = totalNumberRecords / recordPerPage;
        if (totalNumberRecords > numberOfPages * recordPerPage) {
            numberOfPages = numberOfPages + 1;
        }

        request.setAttribute("pageNumbers", numberOfPages);
        return RoutesJSP.ALL_STUDENTS;
    }

    private int getPageNumber(String strNumber) {
        try {
            return Integer.valueOf(strNumber);
        } catch (IllegalArgumentException e) {
            return 1;
        }
    }
}
