package com.djk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private String t_id;
    private String t_name;
    private String t_pwd;
    private String t_gender;
    private String telephone;
}
