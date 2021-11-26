package com.example.faculty.controller.command.account.admin.topic;

import com.example.faculty.controller.command.Command;
import com.example.faculty.model.domain.Topic;
import com.example.faculty.service.interf.TopicService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static com.example.faculty.controller.command.PathCommand.ALL_TOPICS_PAG;
import static com.example.faculty.controller.command.RoutesJSP.REDIRECT;

public class UpdateTopic implements Command {

    private final Logger LOGGER = Logger.getLogger(UpdateTopic.class);

    private TopicService topicService;

    public UpdateTopic(TopicService topicService) {
        this.topicService = topicService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.info("start update topic");
        String topicId = request.getParameter("topic");

        String topicName = request.getParameter("topicName");
        LOGGER.info("Topic name to update - " + topicName);

        Topic topicToUpdate = topicService.findById(Long.valueOf(topicId));
        topicToUpdate.setDate(new Date());
        topicToUpdate.setTopicName(topicName);

        topicService.update(topicToUpdate);

        String contextAndServletPath = request.getContextPath() + request.getServletPath();
        return REDIRECT + contextAndServletPath + ALL_TOPICS_PAG + "?pagination=1";
    }
}
