package com.example.faculty.controller.command.account.admin.topic;

import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;
import com.example.faculty.model.domain.Topic;
import com.example.faculty.service.interf.TopicService;
import com.example.faculty.utils.InputDataValidationUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static com.example.faculty.controller.command.PathCommand.ALL_TOPICS_PAG;
import static com.example.faculty.controller.command.RoutesJSP.REDIRECT;

public class AddTopic implements Command {

    private final Logger LOGGER = Logger.getLogger(AddTopic.class);

    private TopicService topicService;

    public AddTopic(TopicService topicService) {
        this.topicService = topicService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.info("save topic");
        final String topicName = request.getParameter("name");

        if (InputDataValidationUtils.isCorrectName(topicName)) {
            if (!(InputDataValidationUtils.isNullOrEmpty(topicName))) {

                topicService.create(
                        new Topic.Builder()
                                .setDate(new Date())
                                .setTopicName(topicName)
                                .build());

                LOGGER.info("created");
                String contextAndServletPath = request.getContextPath() + request.getServletPath();
                return REDIRECT + contextAndServletPath + ALL_TOPICS_PAG + "?pagination=1";
            } else {
                return RoutesJSP.ADD_TOPIC + "?badInput=true";
            }
        } else {
            return RoutesJSP.ADD_TOPIC + "?notValid=true";
        }

    }
}
