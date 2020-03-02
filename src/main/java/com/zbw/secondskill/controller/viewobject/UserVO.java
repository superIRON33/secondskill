package com.zbw.secondskill.controller.viewobject;

import lombok.Data;

/**
 * @ClassName UserVO.java
 * @Description //用户viewObject
 * @Author ZBW
 * @Date 2020年03月01日 19:21
 **/
@Data
public class UserVO {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户昵称
     */
    private String name;
    /**
     * 用户性别
     */
    private Byte gender;
    /**
     * 用户年龄
     */
    private Integer age;
    /**
     * 用户手机号
     */
    private String telphone;

}
