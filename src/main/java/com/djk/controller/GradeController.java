package com.djk.controller;


import com.djk.pojo.Course;
import com.djk.pojo.Grade;
import com.djk.resultmap.GradeForTeacher;
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
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;
    @RequestMapping("/Student/{sid}")///{stuId}
    public String QueryGradeOfStudent(@PathVariable("sid") String sid,Model model){//
        List<GradeOfStudent> list = userService.queryGradeById(sid);//stuId
        model.addAttribute("list",list);
        return "/grade/gradeOfStudent";
    }
    @RequestMapping("/Teacher/{tid}")
    public String QueryUpdateGradeByCourse(@PathVariable("tid") String tid,Model model){
        List<Course> courses = userService.queryCourseByTId(tid);
        model.addAttribute("courses",courses);
        for (int i = 0; i < courses.size(); i++) {
            List<GradeForTeacher> gradeList = userService.queryGradeForTeacher(tid,courses.get(i).getCourse_id());
            model.addAttribute("gradeOf"+courses.get(i).getCourse_id(),gradeList);
        }
        model.addAttribute("tid",tid);
        return "grade/GradeForTeacher";
    }
    @RequestMapping("/updateGrade/{sid}/{cid}/{tid}")///{stuId}
    public String updateGradeOfStudent(@PathVariable("sid") String sid,@PathVariable("cid") String cid,@PathVariable("tid") String tid, HttpServletRequest request){//
        Grade grade = new Grade();
        grade.setCourse_id(cid);
        grade.setStu_id(sid);
        int gradeNum = Integer.valueOf(request.getParameter("gradeForUpdate")).intValue();
        if (gradeNum > 100 || gradeNum < 0) {
            return "others/GradeError";
        }
        grade.setStu_grade(gradeNum);
        int n = userService.updateGrade(grade);
        System.out.println(cid+" "+sid+" "+gradeNum+ " "+ n + " "+grade);
        return "redirect:/grade/Teacher/"+tid;
    }

}
