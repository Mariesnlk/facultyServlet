package com.example.faculty.controller.command.account.admin.topic;

import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;
import com.example.faculty.model.domain.Topic;
import com.example.faculty.service.interf.TopicService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateTopicCommand implements Command {

    private final Logger LOGGER = Logger.getLogger(AddTopic.class);

    private TopicService topicService;

    public UpdateTopicCommand(TopicService topicService) {
        this.topicService = topicService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String topicId = request.getParameter("topic");

        Topic topic = topicService.findById(Long.valueOf(topicId));
        request.setAttribute("topic", topic);

        return RoutesJSP.UPDATE_TOPIC;
    }
}
