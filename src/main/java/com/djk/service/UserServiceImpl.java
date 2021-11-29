package com.djk.service;

import com.djk.dao.UserMapper;
import com.djk.pojo.*;
import com.djk.resultmap.GradeForTeacher;
import com.djk.resultmap.GradeOfStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Course queryCourseById(String id) {
        return userMapper.queryCourseById(id);
    }

    public int addCourse(Course course) {
        return userMapper.addCourse(course);
    }

    public int deleteCourseById(String id) {
        return userMapper.deleteCourseById(id);
    }

    public int updateCourse(Course course) {
        return userMapper.updateCourse(course);
    }

    public List<Course> queryAllCourse() {
        return userMapper.queryAllCourse();
    }

    public Student queryStudentById(String id) {
        return userMapper.queryStudentById(id);
    }

    public int addStudent(Student student) {
        return userMapper.addStudent(student);
    }

    public int deleteStudentById(String id) {
        return userMapper.deleteStudentById(id);
    }

    public int updateStudent(Student student) {
        return userMapper.updateStudent(student);
    }

    public List<Student> queryAllStudent() {
        return userMapper.queryAllStudent();
    }

    public Teacher queryTeacherById(String id) {
        return userMapper.queryTeacherById(id);
    }

    public int addTeacher(Teacher teacher) {
        return userMapper.addTeacher(teacher);
    }

    public int deleteTeacherById(String id) {
        return userMapper.deleteTeacherById(id);
    }

    public int updateTeacher(Teacher teacher) {
        return userMapper.updateTeacher(teacher);
    }

    public List<Teacher> queryAllTeacher() {
        return userMapper.queryAllTeacher();
    }

    public Admin queryAdminById(String id) {
        return userMapper.queryAdminById(id);
    }

    public int addAdmin(Admin admin) { return userMapper.addAdmin(admin); }

    public int deleteAdminById(String id) {
        return userMapper.deleteAdminById(id);
    }

    public int updateAdmin(Admin admin) {
        return userMapper.updateAdmin(admin);
    }

    public List<Admin> queryAllAdmin() { return userMapper.queryAllAdmin(); }



    public int addGrade(Grade grade) { return userMapper.addGrade(grade); }

    public int deleteGradeById(String id) {
        return userMapper.deleteGradeById(id);
    }

    public int updateGrade(Grade grade) {
        return userMapper.updateGrade(grade);
    }

    public List<GradeOfStudent> queryAllGrade() {
        return userMapper.queryAllGrade();
    }


    public List<GradeOfStudent> queryGradeById(@Param("sid")String id ) { return userMapper.queryGradeById(id);}//

    //验证密码 :学生
    public String verifyCodeOfStudent(@Param("id") String id){
        return userMapper.verifyCodeOfStudent(id);
    }

    //教师
    public String verifyCodeOfTeacher(@Param("id") String id){return userMapper.verifyCodeOfTeacher(id);}

    //管理员
    public String verifyCodeOfAdmin(@Param("id") String id){return userMapper.verifyCodeOfAdmin(id);}

    //教师查课程
    public List<Course> queryCourseByTId(@Param("tId") String id){return userMapper.queryCourseByTId(id);}

    //教师查成绩
    public List<GradeForTeacher> queryGradeForTeacher(@Param("tid") String tid, @Param("cid") String cid){return userMapper.queryGradeForTeacher(tid,cid);}

    //教师查学生
    public List<Student> queryStudentOfCourse(@Param("cid") String cid){return userMapper.queryStudentOfCourse(cid);}

    //学生查课程
    public List<Course> queryCourseBySId(@Param("sid") String id){return userMapper.queryCourseBySId(id);}
}
