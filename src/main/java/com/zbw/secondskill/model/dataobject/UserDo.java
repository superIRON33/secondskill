package com.zbw.secondskill.model.dataobject;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDo {

    private Integer id;
    private String name;
    private Byte gender;
    private Integer age;
    private String telephone;
    private String registerMode;
    private String thirdPartId;
    public UserDo(String name, Byte gender, Integer age, String telephone) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.telephone = telephone;
    }
}