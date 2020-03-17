package com.zbw.secondskill.service.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName UserModel.java
 * @Description //用户领域模型
 * @Author ZBW
 * @Date 2020年02月27日 20:19
 **/
@Data
public class UserModel implements Serializable {
    private Integer id;

    /**
     * 用户昵称
     */
    @NotBlank(message = "用户名不能为空")
    private String name;

    /**
     * 用户性别
     */
    @NotNull(message = "性别不能不填写")
    private Byte gender;

    /**
     * 用户年龄
     */
    @NotNull(message = "年龄不能不填写")
    @Min(value = 0,message = "年龄必须大于0岁")
    @Max(value = 150,message = "年龄必须小于150岁")
    private Integer age;

    /**
     * 用户手机号
     */
    @NotBlank(message = "手机号不能为空")
    private String telphone;

    /**
     * 用户注册方式
     */
    private String registerMode;

    /**
     * 用户第三方id
     */
    private String thirdPartyId;

    /**
     * 用户加密密码
     */
    @NotBlank(message = "密码不能为空")
    private String encrptPassword;
}
