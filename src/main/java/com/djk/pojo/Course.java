package com.djk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private String course_id;
    private String course_name;
    private float credit;
    private float course_hour;
    private String t_id;
}
