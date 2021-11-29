package com.djk.controller;

import com.djk.pojo.Admin;
import com.djk.pojo.Student;
import com.djk.pojo.Teacher;
import com.djk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;
    @RequestMapping("/queryAllStudent")
    public String queryAllStudent(Model model){
        List<Student> list =userService.queryAllStudent();
        model.addAttribute("list",list);
        return "student/AllStudent";
    }
    @RequestMapping("/queryAllTeacher")
    public String queryAllTeacher(Model model){
        List<Teacher> list =userService.queryAllTeacher();
        model.addAttribute("list",list);
        return "teacher/AllTeacher";
    }

    @RequestMapping("toUpdatePwd")///{aid} @PathVariable("aid")String aid,
    public String toUpdateStuPwd( HttpSession session,Model model){

        return "admin/ChangeAPwd";
    }

    @RequestMapping("ChangeAdminPwd/{aid}")
    public String ChangeAdminPwd(@PathVariable("aid") String aid,HttpServletRequest request) throws Exception{
        Admin admin = userService.queryAdminById(aid);
        String oldPwd = admin.getAdmin_pwd();
        String inputOldPwd= request.getParameter("old_pwd");
        String inputNewPwd= request.getParameter("new_pwd");
        String inputNewPwd2= request.getParameter("new_pwd_check");
        if (oldPwd.equals(inputOldPwd)&&inputNewPwd.equals(inputNewPwd2))
        {
            admin.setAdmin_pwd(inputNewPwd);
            userService.updateAdmin(admin);
            return  "others/AdminPwdOk";
        }

        else {
            return "others/PwdError";
        }
    }
    @RequestMapping("MainPage")
    public String MainPage(){
        return "admin/AdminPage";
    }
}
