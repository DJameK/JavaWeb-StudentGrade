package com.djk.resultmap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeForTeacher {
    private String class_name;
    private String stu_id;
    private String stu_name;
    private String course_name;
    private int stu_grade;
}
