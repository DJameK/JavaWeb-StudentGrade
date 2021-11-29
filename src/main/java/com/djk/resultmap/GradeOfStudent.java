package com.djk.resultmap;

import com.djk.pojo.Course;
import com.djk.pojo.Grade;
import com.djk.pojo.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeOfStudent {
    private String stu_id;
    private String stu_name;
    private String course_name;
    private int grade;
}
