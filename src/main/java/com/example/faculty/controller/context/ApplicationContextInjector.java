package com.example.faculty.controller.context;

import com.example.faculty.cipher.AES;
import com.example.faculty.controller.command.Command;
import com.example.faculty.controller.command.account.admin.AdminAccountCommand;
import com.example.faculty.controller.command.account.admin.BlockStudentCommand;
import com.example.faculty.controller.command.account.admin.UpdateAdminCommand;
import com.example.faculty.controller.command.account.admin.courses.*;
import com.example.faculty.controller.command.account.admin.topic.*;
import com.example.faculty.controller.command.account.admin.user.AddTeacher;
import com.example.faculty.controller.command.account.admin.user.ShowAllStudentsCommand;
import com.example.faculty.controller.command.account.admin.user.ShowAllTeachersCommand;
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

    private static final UserDao USER_DAO = new UserDaoImpl(CONNECTOR);
    private static final TopicDao TOPIC_DAO = new TopicDaoImpl(CONNECTOR);
    private static final CourseDao COURSE_DAO = new CourseDaoImpl(CONNECTOR, USER_DAO);
    private static final EnrollDao ENROLL_DAO = new EnrollDaoImpl(CONNECTOR);
    private static final GradeBookDao GRADE_BOOK_DAO = new GradeBookDaoImpl(CONNECTOR);
    private static final CourseWithMyMarkDao COURSE_WITH_MY_MARK_DAO = new CourseWithMyMarkDaoImpl(CONNECTOR);
    private static final StudentMarkDaoImpl STUDENT_MARK_DAO = new StudentMarkDaoImpl(CONNECTOR);

    private static final UserMapper USER_MAPPER = new UserMapper();
    private static final TopicMapper TOPIC_MAPPER = new TopicMapper();
    private static final CourseMapper COURSE_MAPPER = new CourseMapper(TOPIC_MAPPER, USER_MAPPER);
    private static final EnrollMapper ENROLL_MAPPER = new EnrollMapper(COURSE_MAPPER, USER_MAPPER);
    private static final GradeBookMapper GRADE_BOOK_MAPPER = new GradeBookMapper(COURSE_MAPPER, USER_MAPPER);

    private static final UserService USER_SERVICE = new UserServiceImpl(USER_DAO, USER_MAPPER);
    private static final TopicService TOPIC_SERVICE = new TopicServiceImpl(TOPIC_DAO, TOPIC_MAPPER);
    private static final CourseService COURSE_SERVICE = new CourseServiceImpl(COURSE_DAO, COURSE_MAPPER);
    private static final EnrollService ENROLL_SERVICE = new EnrollServiceImpl(ENROLL_DAO, ENROLL_MAPPER);
    private static final GradeBookService GRADE_BOOK_SERVICE = new GradeBookServiceImpl(GRADE_BOOK_DAO, GRADE_BOOK_MAPPER);


    private static final Map<String, Command> NAME_COMMAND_TO_COMMANDS = initCommand();

    public Map<String, Command> getNameCommandToCommands() {
        return NAME_COMMAND_TO_COMMANDS;
    }

    private static Map<String, Command> initCommand() {
        Map<String, Command> commands = new HashMap<>();
        commands.put(HOME_PAGE, new HomeCommand());
        commands.put(REGISTER_PAGE, new RegisterStudentCommand());
        commands.put(REGISTER_USER, new RegistrationCommand(USER_SERVICE));
        commands.put(LOGIN_PAGE, new LoginCommand());
        commands.put(LOGIN, new EnterLoginCommand(USER_SERVICE));
        commands.put(LOGOUT, new LogoutCommand());
        commands.put(STUDENT_ACCOUNT, new StudentAccountCommand());
        commands.put(TEACHER_ACCOUNT, new TeacherAccountCommand());
        commands.put(ADMIN_ACCOUNT, new AdminAccountCommand());
        commands.put(FORBIDDEN, new ErrorForbiddenCommand());
        commands.put(ABOUT, new AboutCommand());
        commands.put(CONTACTS, new ContactsCommand());
        commands.put(BLOCK_STUDENT, new BlockStudentCommand());
        commands.put(ADD_TOPIC_FORM, new AddTopicCommand());
        commands.put(ADD_TOPIC, new AddTopic(TOPIC_SERVICE));
        commands.put(UPDATE_TOPIC_FORM, new UpdateTopicCommand(TOPIC_SERVICE));
        commands.put(UPDATE_TOPIC, new UpdateTopic(TOPIC_SERVICE));
        commands.put(ALL_TOPICS_PAG, new ShowAllTopicsCommand(TOPIC_SERVICE));
        commands.put(DELETE_TOPIC_PATH, new DeleteTopic(TOPIC_SERVICE));
        commands.put(ALL_COURSES_PAG, new ShowAllCoursesCommand(COURSE_SERVICE, TOPIC_SERVICE, USER_SERVICE));
        commands.put(ADD_COURSE_FORM, new AddCoursesCommand(TOPIC_SERVICE, USER_SERVICE));
        commands.put(ADD_COURSE, new AddCourses(TOPIC_SERVICE, USER_SERVICE, COURSE_SERVICE));
        commands.put(UPDATE_COURSE_FORM, new UpdateCoursesCommand(TOPIC_SERVICE, USER_SERVICE, COURSE_SERVICE));
        commands.put(UPDATE_COURSES, new UpdateCourses(TOPIC_SERVICE, USER_SERVICE, COURSE_SERVICE));
        commands.put(DELETE_COURSE_PATH, new DeleteCourse(COURSE_SERVICE));
        commands.put(COURSE_INF0, new CourseInfoCommand(TOPIC_SERVICE, USER_SERVICE, COURSE_SERVICE, STUDENT_MARK_DAO));
        commands.put(ALL_STUDENTS, new AllStudentsCommand());
        commands.put(ALL_STUDENTS_PAG, new ShowAllStudentsCommand(USER_SERVICE));
        commands.put(UPDATE_STUDENT_FORM, new UpdateStudentCommand());
        commands.put(UPDATE_ADMIN_FORM, new UpdateAdminCommand());
        commands.put(UPDATE_TEACHER_FORM, new UpdateTeacherCommand());
        commands.put(UPDATE_USER, new UpdateUserCommand(USER_SERVICE));
        commands.put(STUDENT_COURSES, new StudentCoursesCommand(COURSE_WITH_MY_MARK_DAO, TOPIC_SERVICE, USER_SERVICE));
        commands.put(ALL_TEACHERS, new AllTeachersCommand());
        commands.put(ALL_TEACHERS_PAG, new ShowAllTeachersCommand(USER_SERVICE));
        commands.put(ADD_TEACHER, new AddTeacher(USER_SERVICE));
        commands.put(ADD_TEACHER_FORM, new AddTeacherCommand());
        commands.put(TEACHER_COURSES_PAG, new ShowTeacherCoursesCommand(COURSE_SERVICE, TOPIC_SERVICE, USER_SERVICE));
        commands.put(IS_TEACHER, new IsTeacherCommand());
        commands.put(TEACHER_REGISTRATION_COMPLETE, new TeacherRegistrationCompleteCommand(USER_SERVICE));
        commands.put(ENROLL, new EnrollCommand(ENROLL_SERVICE, COURSE_SERVICE, TOPIC_SERVICE, USER_SERVICE));
        commands.put(SET_MARK, new SetMarkCommand(GRADE_BOOK_SERVICE));
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
