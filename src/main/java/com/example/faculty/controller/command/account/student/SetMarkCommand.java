package com.example.faculty.controller.command.account.student;

import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.RoutesJSP;
import com.example.faculty.service.interf.GradeBookService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetMarkCommand implements Command {

    private final Logger LOGGER = Logger.getLogger(SetMarkCommand.class);

    private final GradeBookService gradeBookService;

    public SetMarkCommand(GradeBookService gradeBookService) {
        this.gradeBookService = gradeBookService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.info("set mark");

        Long courseId = Long.parseLong(request.getParameter("course"));
        Long studentId = Long.parseLong(request.getParameter("student"));
        Integer mark = Integer.parseInt(request.getParameter("mark"));
        LOGGER.info("MARK - " + mark);

        gradeBookService.saveMark(studentId, courseId, mark);

        return RoutesJSP.TEACHER_ACCOUNT;
    }
}
