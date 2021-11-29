package com.example.faculty.dao.interf;

import com.example.faculty.model.entity.CourseEntity;
import com.example.faculty.model.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface CourseDao extends CrudDao<CourseEntity, Long> {

    Boolean existsCourseByName(String name);

    long findCountCourses();

    List<CourseEntity> findAllCourses(int row, int limit);

//    Page<Course> findAllBy(Pageable pageable);
//
//    Page<Course> findCoursesByTeacherId(User teacherId, Pageable pageable);
//
//
//    @Query("select c from Course c where " +
//            "c.name in (:courseName) and " +
//            "c.duration in (:duration) and " +
//            "c.studentsAmount in (:studentsAmount) and " +
//            "c.topic.name in (:topic) and " +
//            "c.teacherId.id in (:teacherId) and " +
//            "c.status in (:status) ")
//    Page<Course> findAllByParams(@Param("courseName") List<String> courseName, @Param("duration") List<Integer> duration,
//                                 @Param("studentsAmount") List<Integer> studentsAmount, @Param("topic") List<String> topic,
//                                 @Param("status") List<String> status, @Param("teacherId") List<Integer> teacherId,
//                                 Pageable pageable);
//
//
//    @Query("select c from Course c " +
//            "inner join Enroll e " +
//            "on c.id = e.idCourse " +
//            "where e.idUser=:userId and " +
//            "c.name in (:courseName) and " +
//            "c.duration in (:duration) and " +
//            "c.studentsAmount in (:studentsAmount) and " +
//            "c.topic.name in (:topic) and " +
//            "c.teacherId.id in (:teacherId) and " +
//            "c.status in (:status) ")
//    Page<Course> findAllCoursesByNewParamsAndStudent(@Param("courseName") List<String> courseName, @Param("duration") List<Integer> duration,
//                                                     @Param("studentsAmount") List<Integer> studentsAmount, @Param("topic") List<String> topic,
//                                                     @Param("teacherId") List<Integer> teacherId, @Param("status") List<String> status,
//                                                     @Param("userId") Long userId, Pageable pageable);
//
//    @Query("select c from Course c " +
//            "inner join Enroll e " +
//            "on c.id = e.idCourse " +
//            "where e.idUser=:userId")
//    Page<Course> findAllCoursesByStudent(@Param("userId") Long userId, Pageable pageable);
//
//    @Query("select c from Course c where c.teacherId.id is null")
//    List<Course> findCoursesWithoutTeacher();
//
//    @Query("select distinct(c.name) from Course c")
//    List<String> findAllCourseNames();
//
//    @Query("select distinct(c.duration) from Course c")
//    List<Integer> findAllDurations();
//
//    @Query("select distinct(c.studentsAmount) from Course c")
//    List<Integer> findAllStudentsAmount();
//
//    @Query("select t.name from Topic t")
//    List<String> findAllTopics();
//
//    @Query("select t.id from User t")
//    List<Integer> findAllTeacherNames();
//
//    @Query("select c.name from Course c where lower(c.name) like lower(concat('%',:name,'%') )")
//    List<String> findCourseNameByName(@Param("name") String name);
//
//    @Query("select t.id from User t where lower(concat(t.lastName,' ',t.firstName,' ',t.secondName)) like lower(concat('%',:name,'%') )")
//    List<Integer> findTeacherIdByName(@Param("name") String name);

}
