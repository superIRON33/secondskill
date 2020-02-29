package com.zbw.secondskill.common.enums;

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
     * 请求失败
     */
    FAILED(10000, "接口请求失败"),

    /**
     * 传入对象空
     */
    OBJECT_NOT_EXISTS(10001, "传入对象空"),

    /**
     * 短信验证不符合
     */
    OPT_INVALID(10002,"短信验证不符合"),

    /**
     * 传入参数不合法
     */
    ILLEGAL_PARAMETER(10003, "传入参数不合法"),

    /**
     * 密码加密异常
     */
    PASSWORD_EXCEPTION(10004, "密码加密异常"),

    /**
     * 手机号已重复注册
     */
    TELEPHONE_EXISTED(10005, "手机号已重复注册"),

    /**
     * 手机号或者密码错误
     */
    LOGIN_FAIL(10006, "手机号或者密码错误"),

    /**
     * id无效
     */
    ID_INVALID(10007, "id无效"),

    /**
     * 添加商品失败
     */
    CREATE_ITEM_FAIL(20001, "添加商品失败");

    private Integer code;
    private String message;
}