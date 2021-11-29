package com.djk.controller;

import com.djk.pojo.Student;
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
@RequestMapping("/student")
public class StudentController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;
    @RequestMapping("/allStudent")
    public String QueryAllStudent(Model model ){
        List<Student> list = userService.queryAllStudent();
        model.addAttribute("list",list);
        return "student/AllStudent";
    }

    @RequestMapping("/addAStudent")
    public String AddStudent(Model model , Student student/*,HttpServletResponse response*/){
        //调用了有参构造器
//        student.setStu_id(request.getParameter("stuId"));
//        student.setStu_name(request.getParameter("stuName"));
//        student.setStu_gender(request.getParameter("gender"));
//        student.setStu_pwd(request.getParameter("pwd"));
//        student.setClass_name(request.getParameter("classname"));
//        student.setTelephone(request.getParameter("telephone"));

        try {
            userService.addStudent(student);
        }catch (org.springframework.dao.DuplicateKeyException e) {
            return "others/AddError";
        }
            return "redirect:/student/allStudent";
    }
    @RequestMapping("/toAddStudent")
    public String toAddStudent(){
        return "student/AddStudent";
    }

    @RequestMapping("/del/{stuId}")
    public String deleteStudent(@PathVariable("stuId") String id) {
        userService.deleteStudentById(id);
        return "redirect:/student/allStudent";
    }


    @RequestMapping("toUpdateStudent/{id}")
    public String toUpdateStudent(@PathVariable("id") String id,Model model) {
        Student student = userService.queryStudentById(id);
        model.addAttribute("student",student );
        return "student/UpdateStudent";
    }

    @RequestMapping("/updateAStudent")
    public String updateStudent(Model model, Student student) {
        System.out.println(student);
        userService.updateStudent(student);
//          Student aStudent =
//        userService.queryStudentById(student.getStu_id());
//        model.addAttribute("student", aStudent);
        return "redirect:/student/allStudent";
    }
    @RequestMapping("toUpdatePwd/{sid}")
    public String toUpdateStuPwd(@PathVariable("sid") String  sid,Model model){
        model.addAttribute("sid",sid);
        return "/student/ChangeSPwd";
    }

    @RequestMapping("ChangeStudentPwd/{sid}")
    public String ChangeStuPwd(@PathVariable("sid") String sid,HttpServletRequest request){
        Student student = userService.queryStudentById(sid);
        String oldPwd = student.getStu_pwd();
        String inputOldPwd= request.getParameter("old_pwd");
        String inputNewPwd= request.getParameter("new_pwd");
        String inputNewPwd2= request.getParameter("new_pwd_check");
        if (oldPwd.equals(inputOldPwd)&&inputNewPwd.equals(inputNewPwd2))
            {
                student.setStu_pwd(inputNewPwd);
                userService.updateStudent(student);
                return  "others/StudentPwdOk";
            }

        else {
            return "others/PwdError";
        }
    }
    @RequestMapping("MainPage")
    public String MainPage(){
        return "student/StudentPage";
    }
}
