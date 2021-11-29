package com.djk.service;

import com.djk.pojo.*;
import com.djk.resultmap.GradeForTeacher;
import com.djk.resultmap.GradeOfStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    Course queryCourseById(@Param("courseId") String id);

    int addCourse(Course course);

    int deleteCourseById(@Param("id") String id);

    int updateCourse(Course course);

    List<Course> queryAllCourse();


    //Student CURD

    Student queryStudentById(@Param("stuId") String id);

    int addStudent(Student student);

    int deleteStudentById(@Param("stuId") String id);

    int updateStudent(Student student);

    List<Student> queryAllStudent();

    //Teacher CURD

    Teacher queryTeacherById(@Param("tId") String id);

    int addTeacher(Teacher teacher);

    int deleteTeacherById(@Param("tId") String id);

    int updateTeacher(Teacher teacher);

    List<Teacher> queryAllTeacher();

    //Admin CURD

    Admin queryAdminById(@Param("adminId") String id);

    int addAdmin(Admin admin);

    int deleteAdminById(@Param("adminId") String id);

    int updateAdmin(Admin admin);

    List<Admin> queryAllAdmin();

    //Grade CURD



    int addGrade(Grade grade);

    int deleteGradeById(@Param("stuId") String id);

    int updateGrade(Grade grade);

    List<GradeOfStudent> queryAllGrade();


    List<GradeOfStudent> queryGradeById(@Param("id") String id);//

    //验证密码 :学生
    String verifyCodeOfStudent(@Param("id") String id);

    //验证密码 :教师
    String verifyCodeOfTeacher(@Param("id") String id);

    //验证密码 :管理员
    String verifyCodeOfAdmin(@Param("id") String id);

    //教师查课程
    List<Course> queryCourseByTId(@Param("tId") String id);
    //教师查成绩
    List<GradeForTeacher> queryGradeForTeacher(@Param("tid") String tid,@Param("cid") String cid);
    //教师查学生
    List<Student> queryStudentOfCourse(@Param("cid") String cid);
    //学生查课程
    List<Course> queryCourseBySId(@Param("sid") String id);
}
