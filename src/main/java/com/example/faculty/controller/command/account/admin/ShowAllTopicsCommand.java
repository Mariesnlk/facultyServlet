package com.example.faculty.controller.command.account.admin;

import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;
import com.example.faculty.model.domain.Topic;
import com.example.faculty.service.interf.TopicService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowAllTopicsCommand implements Command {

    private final Logger LOGGER = Logger.getLogger(ShowAllTopicsCommand.class);

    private TopicService topicService;

    public ShowAllTopicsCommand(TopicService topicService) {
        this.topicService = topicService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("ShowAllTopicsCommand");
        int pageNumber;
        int totalNumberRecords = (int) topicService.getAllTopicsCount();
        int recordPerPage = 5;
        int startIndex;
        int numberOfPages;

        String sPageNo = request.getParameter("pagination");

        pageNumber = getPageNumber(sPageNo);
        startIndex = (pageNumber * recordPerPage) - recordPerPage;
        List<Topic> topicList = topicService.getAllTopics(startIndex, recordPerPage);

        request.setAttribute("topicList", topicList);
        request.setAttribute("recordPerPage", recordPerPage);
        numberOfPages = totalNumberRecords / recordPerPage;
        if (totalNumberRecords > numberOfPages * recordPerPage) {
            numberOfPages = numberOfPages + 1;
        }

        request.setAttribute("pageNumbers", numberOfPages);
        return RoutesJSP.ALL_TOPICS;
    }

    private int getPageNumber(String strNumber) {
        try {
            return Integer.valueOf(strNumber);
        } catch (IllegalArgumentException e) {
            return 1;
        }
    }
}
