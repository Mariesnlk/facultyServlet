create database `facultyservlet`;

use `facultyservlet`;
SET NAMES utf8;

SET character_set_client = utf8mb4;

CREATE TABLE `user`
(
    id           bigint unsigned                              NOT NULL AUTO_INCREMENT,
    created_date datetime                                     NOT NULL,
    first_name   VARCHAR(35)                                  NOT NULL,
    second_name  VARCHAR(35)                                  NOT NULL,
    last_name    VARCHAR(35)                                  NOT NULL,
    email        VARCHAR(80)                                  NOT NULL,
    password     VARCHAR(255)                                 NOT NULL,
    role         ENUM ('STUDENT', 'TEACHER', 'ADMINISTRATOR') NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `topic`
(
    id           bigint unsigned NOT NULL AUTO_INCREMENT,
    created_date datetime        NOT NULL,
    name         VARCHAR(35)     NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `course`
(
    id              bigint unsigned NOT NULL AUTO_INCREMENT,
    created_date    datetime        NOT NULL,
    name            VARCHAR(35)     NOT NULL,
    status          VARCHAR(35)     NOT NULL,
    students_amount int             NOT NULL,
    enroll_students int             NOT NULL,
    duration        int             NOT NULL,
    topic_id        bigint          NOT NULL,
    teacher_id      bigint          NOT NULL,
    PRIMARY KEY (`id`),
    KEY `fk_topic_id` (`topic_id`),
    KEY `fk_teacher_id` (`teacher_id`),
    CONSTRAINT `fk_topic_id` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`),
    CONSTRAINT `fk_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`id`)
);

CREATE TABLE `enroll`
(
    id           bigint unsigned NOT NULL AUTO_INCREMENT,
    created_date datetime        NOT NULL,
    student_id   bigint          NOT NULL,
    course_id    bigint          NOT NULL,
    PRIMARY KEY (`id`),
    KEY `fk_student_id` (`student_id`),
    KEY `fk_course_id` (`course_id`),
    CONSTRAINT `fk_student_id` FOREIGN KEY (`student_id`) REFERENCES `user` (`id`),
    CONSTRAINT `fk_course_id` FOREIGN KEY (`course_id`) REFERENCES `user` (`id`)
);

CREATE TABLE `gradebook`
(
    id           bigint unsigned NOT NULL AUTO_INCREMENT,
    created_date datetime        NOT NULL,
    mark         int             NOT NULL,
    student_id   bigint          NOT NULL,
    course_id    bigint          NOT NULL,
    PRIMARY KEY (`id`),
    KEY `fk_student_id` (`student_id`),
    KEY `fk_course_id` (`course_id`),
    CONSTRAINT `fk_student_id` FOREIGN KEY (`student_id`) REFERENCES `user` (`id`),
    CONSTRAINT `fk_course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
);