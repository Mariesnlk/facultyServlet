package com.example.faculty.controller.context;

import com.example.faculty.cipher.AES;
import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.account.admin.*;
import com.example.faculty.controller.command.account.student.*;
import com.example.faculty.controller.command.account.teacher.*;
import com.example.faculty.controller.command.common.*;
import com.example.faculty.dao.impl.*;
import com.example.faculty.dao.interf.*;
import com.example.faculty.database.DBHelper;
import com.example.faculty.model.mapper.*;
import com.example.faculty.service.impl.*;
import com.example.faculty.service.interf.*;

import java.util.HashMap;
import java.util.Map;

import static com.example.faculty.controller.command.PathCommand.*;

public class ApplicationContextInjector {

    private static final DBHelper CONNECTOR = new DBHelper();
    private static final AES ENCODER_PASSWORD = new AES();

    private static final UserDao USER_DAO = new UserDaoImpl();
    private static final TopicDao TOPIC_DAO = new TopicDaoImpl();
    private static final CourseDao COURSE_DAO = new CourseDaoImpl();
    private static final EnrollDao ENROLL_DAO = new EnrollDaoImpl();
    private static final GradeBookDao GRADE_BOOK_DAO = new GradeBookDaoImpl();

    private static final UserMapper USER_MAPPER = new UserMapper();
    private static final TopicMapper TOPIC_MAPPER = new TopicMapper();
    private static final CourseMapper COURSE_MAPPER = new CourseMapper(TOPIC_MAPPER, USER_MAPPER);
    private static final EnrollMapper ENROLL_MAPPER = new EnrollMapper(COURSE_MAPPER, USER_MAPPER);
    private static final GradeBookMapper GRADE_BOOK_MAPPER = new GradeBookMapper(COURSE_MAPPER, USER_MAPPER);

    private static final UserService USER_SERVICE = new UserServiceImpl();
    private static final TopicService TOPIC_SERVICE = new TopicServiceImpl();
    private static final CourseService COURSE_SERVICE = new CourseServiceImpl();
    private static final EnrollService ENROLL_SERVICE = new EnrollServiceImpl();
    private static final GradeBookService GRADE_BOOK_SERVICE = new GradeBookServiceImpl();


    private static final Map<String, Command> NAME_COMMAND_TO_COMMANDS = initCommand();

    public Map<String, Command> getNameCommandToCommands() {
        return NAME_COMMAND_TO_COMMANDS;
    }

    private static Map<String, Command> initCommand() {
        Map<String, Command> commands = new HashMap<>();
        commands.put(LOGIN, new LoginCommand());
        commands.put(LOGOUT, new LogoutCommand());
        commands.put(STUDENT_ACCOUNT, new StudentAccountCommand());
        commands.put(TEACHER_ACCOUNT, new TeacherAccountCommand());
        commands.put(ADMIN_ACCOUNT, new AdminAccountCommand());
        commands.put(FORBIDDEN, new ErrorForbiddenCommand());
        commands.put(REGISTER_USER, new RegisterStudentCommand());
        commands.put(ABOUT, new AboutCommand());
        commands.put(CONTACTS, new ContactsCommand());
        commands.put(BLOCK_STUDENT, new BlockStudentCommand());
        commands.put(ADD_TOPIC, new AddTopicCommand());
        commands.put(UPDATE_TOPIC, new UpdateTopicCommand());
        commands.put(ALL_TOPICS, new AllTopicsCommand());
        commands.put(ALL_COURSES, new AllCoursesCommand());
        commands.put(ADD_COURSES, new AddCouCoursesCommand());
        commands.put(UPDATE_COURSES, new UpdateCoursesCommand());
        commands.put(ALL_STUDENTS, new AllStudentsCommand());
        commands.put(UPDATE_STUDENT, new UpdateStudentCommand());
        commands.put(STUDENT_COURSES, new StudentCoursesCommand());
        commands.put(ALL_TEACHERS, new AllTeachersCommand());
        commands.put(ADD_TEACHER, new AddTeacherCommand());
        commands.put(UPDATE_TEACHER, new UpdateTeacherCommand());
        commands.put(TEACHER_COURSES, new TeacherCoursesCommand());
        return commands;
    }

    private static ApplicationContextInjector injector;

    private ApplicationContextInjector() {
    }

    public static ApplicationContextInjector getInstance() {
        if (injector == null) {
            synchronized (ApplicationContextInjector.class) {
                if (injector == null) {
                    injector = new ApplicationContextInjector();
                }
            }
        }
        return injector;
    }

    public UserService getUserService() {
        return USER_SERVICE;
    }

    public TopicService getTopicService() {
        return TOPIC_SERVICE;
    }

    public CourseService getCourseService() {
        return COURSE_SERVICE;
    }

    public EnrollService getEnrollService() {
        return ENROLL_SERVICE;
    }

    public GradeBookService getGradeBookService() {
        return GRADE_BOOK_SERVICE;
    }
}
