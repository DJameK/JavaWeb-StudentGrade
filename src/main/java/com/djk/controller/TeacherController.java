package com.djk.controller;

import com.djk.pojo.Admin;
import com.djk.pojo.Course;
import com.djk.pojo.Student;
import com.djk.pojo.Teacher;
import com.djk.resultmap.GradeForTeacher;
import com.djk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;
@Controller
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;
    @RequestMapping("/allTeacher")
    public String QueryAllTeacher(Model model ){
        List<Teacher> list = userService.queryAllTeacher();
        model.addAttribute("list",list);
        return "teacher/AllTeacher";
    }

    @RequestMapping("/addATeacher")
    public String AddTeacher(Model model , Teacher teacher){
        try {
            userService.addTeacher(teacher);
        }catch (org.springframework.dao.DuplicateKeyException e) {
            return "others/AddError";
        }
        return "redirect:/teacher/allTeacher";
    }
    @RequestMapping("/toAddTeacher")
    public String toAddTeacher(){
        return "teacher/AddTeacher";
    }

    @RequestMapping("/del/{teacherId}")
    public String deleteTeacher(@PathVariable("teacherId") String id) {
        userService.deleteTeacherById(id);
        return "redirect:/teacher/allTeacher";
    }


    @RequestMapping("toUpdateTeacher")
    public String toUpdateTeacher(Model model, String id) {
        Teacher teacher = userService.queryTeacherById(id);
        System.out.println("to"+teacher);
        model.addAttribute("teacher",teacher );
        return "/teacher/UpdateTeacher";
    }

    @RequestMapping("/updateATeacher")
    public String updateATeacher(Model model, Teacher teacher) {
        userService.updateTeacher(teacher);
        System.out.println("up"+teacher);
        model.addAttribute("Teacher", teacher);
        return "redirect:/admin/queryAllTeacher";
    }

    @RequestMapping("/queryStudent/{tid}")
    public String updateBook(@PathVariable("tid") String tid, Model model) {
        List<Course> courses = userService.queryCourseByTId(tid);
        model.addAttribute("courses",courses);
        for (int i = 0; i < courses.size(); i++) {
            List<Student> list =userService.queryStudentOfCourse(courses.get(i).getCourse_id());
            model.addAttribute("studentOf"+courses.get(i).getCourse_id(),list);
            System.out.println(list);
        }
        return "student/StudentOfTeacher";
    }

    @RequestMapping("toUpdatePwd/{tid}")
    public String toUpdateStuPwd(@PathVariable("tid")String tid, HttpSession session, Model model){
        Teacher teacher = (Teacher)session.getAttribute("Teacher");
        model.addAttribute("tid",tid);
        return "teacher/ChangeTPwd";
    }

    @RequestMapping("ChangeTeacherPwd/{tid}")
    public String ChangeAdminPwd(@PathVariable("tid") String tid, HttpServletRequest request){
        Teacher teacher = userService.queryTeacherById(tid);
        String oldPwd = teacher.getT_pwd();
        String inputOldPwd= request.getParameter("old_pwd");
        String inputNewPwd= request.getParameter("new_pwd");
        String inputNewPwd2= request.getParameter("new_pwd_check");
        if (oldPwd.equals(inputOldPwd)&&inputNewPwd.equals(inputNewPwd2))
        {
            teacher.setT_pwd(inputNewPwd);
            userService.updateTeacher(teacher);
            return  "others/TeacherPwdOk";
        }

        else {
            return "others/PwdError";
        }
    }
    @RequestMapping("MainPage")
    public String MainPage(){
        return "teacher/TeacherPage";
    }
}
