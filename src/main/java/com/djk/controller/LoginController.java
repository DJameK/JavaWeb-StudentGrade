package com.djk.controller;

import com.djk.pojo.Admin;
import com.djk.pojo.Student;
import com.djk.pojo.Teacher;
import com.djk.resultmap.GradeOfStudent;
import com.djk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("loginPage")
public class LoginController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;
    @RequestMapping()
    public String login(HttpSession session,HttpServletRequest request,Model model) throws Exception {//, String username, String pwd,String identity
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        String identity =request.getParameter("identity");
//        System.out.println(identity+username+pwd+" "+userService.verifyCodeOfStudent(username));
        if ("Student".equals(identity)){
            if (pwd.equals(userService.verifyCodeOfStudent(username))){
                Student student = userService.queryStudentById(username);
//                model.addAttribute("Student",student);
                session.setAttribute("Student",student);
                return "student/StudentPage";
            }
            else {
                request.setAttribute("Name",identity);
                return "others/LoginError";
            }
        }

        else if ("Teacher".equals(identity)){
            if (pwd.equals(userService.verifyCodeOfTeacher(username))){
                Teacher teacher = userService.queryTeacherById(username);
//                model.addAttribute("Teacher",teacher);
                session.setAttribute("Teacher",teacher);
                return "teacher/TeacherPage";
            }
            else {
                request.setAttribute("Name",identity);
                return "others/LoginError";
            }
        }
        else if ("Admin".equals(identity)){
            if (pwd.equals(userService.verifyCodeOfAdmin(username))){
                Admin admin = userService.queryAdminById(username);
//                model.addAttribute("Admin",admin);
                session.setAttribute("Admin",admin);
                return "admin/AdminPage";
            }
            else {
                session.setAttribute("Name",identity);
                return "others/LoginError";
            }
        }
        else{
            request.setAttribute("Name",identity);
            return "others/LoginError";
        }

    }
    @RequestMapping("logOut")
    public String logout(HttpSession session) {
        session.invalidate();
        return "others/ExitLogin";
    }
    @RequestMapping("logOutOk")
    public String logoutOk(HttpSession session) {
        return "redirect: Login.jsp";
    }
}
