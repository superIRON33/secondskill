package com.zbw.secondskill.model.dto;

import lombok.Data;

/**
 * @ClassName UserVo.java
 * @Description //TODO
 * @Author ZBW
 * @Date 2020年02月27日 23:37
 **/
@Data
public class UserDTO {
    private Integer id;
    private String name;
    private Byte gender;
    private Integer age;
    private String telephone;
}
