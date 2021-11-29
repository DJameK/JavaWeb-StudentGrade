package com.djk.controller;

import com.djk.pojo.Course;
import com.djk.pojo.Student;
import com.djk.resultmap.GradeOfStudent;
import com.djk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;
    @RequestMapping("/Teacher/{tid}")///{stuId}
    public String QueryCourseByTeacher( @PathVariable("tid") String tid,Model model){//@PathVariable("stuId") String stuId,
        System.out.println(tid);
        List<Course> list = userService.queryCourseByTId(tid);//stuId
        model.addAttribute("list",list);
        System.out.println(list);
        return "/course/CourseOfTeacher";
    }
    @RequestMapping("/Student/{sid}")///{stuId}
    public String QueryCourseByStudent( @PathVariable("sid") String sid,Model model){//@PathVariable("stuId") String stuId,
        List<Course> list = userService.queryCourseBySId(sid);//stuId
        model.addAttribute("list",list);
        System.out.println(list);
        return "/course/CourseForStudent";
    }
    @RequestMapping("/toUpdateCourse/{cid}")
    public String toUpdateCourse( @PathVariable("cid") String cid,Model model){
        Course course = userService.queryCourseById(cid);
        model.addAttribute("course",course);
//        System.out.println(list);
        return "/course/UpdateCourse";
    }
    @RequestMapping("/updateACourse")
    public String updateACourse(Course course){
        userService.updateCourse(course);
        return "redirect:/course/queryAllCourse";
    }
    @RequestMapping("/queryAllCourse")
    public String queryAllCourse(Model model){
        List<Course> list =userService.queryAllCourse();
        model.addAttribute("list",list);
        return "course/AllCourse";
    }
    @RequestMapping("/toAddCourse")
    public String toAddCourse(){
        return "/course/AddCourse";
    }

    @RequestMapping("/addACourse")
    public String addACourse(Course course){
        try {
            userService.addCourse(course);
        }catch (org.springframework.dao.DuplicateKeyException e){
            return "others/AddError";
        }
        return "redirect:/course/queryAllCourse";
    }
    @RequestMapping("/del/{cid}")
    public String deleteStudent(@PathVariable("cid") String id) {
        int n=userService.deleteCourseById(id);
        System.out.println(id+"  "+n);
        return "redirect:/course/queryAllCourse";
    }
}
