package com.zbw.secondskill.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: zbw
 * @Date: 2020/2/3 12:31
 * @Description: 异常返回枚举类
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {
    
    /**
     * 正常返回(官方)
     */
    SUCCESS(200, "正常返回"),

    /**
     * 传入对象空
     */
    OBJECT_NOT_EXISTS(10000, "传入对象空"),

    /**
     * 用户id无效
     */
    ID_INVALID(20001, "用户id无效");

    private Integer code;
    private String message;
}