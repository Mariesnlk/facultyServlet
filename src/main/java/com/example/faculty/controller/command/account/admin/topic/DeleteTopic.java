package com.example.faculty.controller.command.account.admin.topic;

import com.example.faculty.controller.command.Command;
import com.example.faculty.service.interf.TopicService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.faculty.controller.command.PathCommand.ALL_TOPICS_PAG;
import static com.example.faculty.controller.command.RoutesJSP.REDIRECT;

public class DeleteTopic implements Command {

    private final Logger LOGGER = Logger.getLogger(AddTopic.class);

    private TopicService topicService;

    public DeleteTopic(TopicService topicService) {
        this.topicService = topicService;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String topicId = request.getParameter("topic");

        topicService.delete(topicService.findById(Long.valueOf(topicId)));

        String contextAndServletPath = request.getContextPath() + request.getServletPath();
        return REDIRECT + contextAndServletPath + ALL_TOPICS_PAG + "?pagination=1";
    }
}
