package com.zbw.secondskill.model.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName UserVo.java
 * @Description //用户信息封装
 * @Author ZBW
 * @Date 2020年02月27日 23:37
 **/
@Data
public class UserDTO {
    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String name;

    /**
     * 用户性别
     */
    @NotNull(message = "性别不能为空")
    private Byte gender;

    /**
     * 用户年龄
     */
    @NotNull(message = "年龄不能为空")
    @Min(value = 0, message = "年龄必须大于0")
    @Max(value = 150, message = "年龄必须小于150岁")
    private Integer age;

    /**
     * 用户联系方式
     */
    @NotBlank(message = "手机号不能为空")
    private String telephone;
}
