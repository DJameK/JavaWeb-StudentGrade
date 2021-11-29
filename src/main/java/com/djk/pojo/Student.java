package com.djk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private String stu_id;
    private String stu_name;
    private String stu_gender;
    private String class_name;
    private String stu_pwd;
    private String telephone;

}
