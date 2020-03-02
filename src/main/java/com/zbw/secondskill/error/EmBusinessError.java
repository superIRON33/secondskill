package com.zbw.secondskill.error;


/**
 * @ClassName EmBusinessError.java
 * @Description //通用类型异常定义枚举类
 * @Author ZBW
 * @Date 2020年02月29日 16:55
 **/
public enum EmBusinessError implements CommonError {
    /**
     * 参数不合法
     */
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),
    /**
     * 未知错误
     */
    UNKNOWN_ERROR(10002,"未知错误"),

    /**
     * 20000开头为用户信息相关错误定义
     * 用户不存在
     */
    USER_NOT_EXIST(20001,"用户不存在"),

    /**
     * 用户手机号或密码不正确
     */
    USER_LOGIN_FAIL(20002,"用户手机号或密码不正确"),

    /**
     * 用户还未登陆
     */
    USER_NOT_LOGIN(20003,"用户还未登陆"),

    /**
     * 30000开头为交易信息错误定义
     * 库存不足
     */
    STOCK_NOT_ENOUGH(30001,"库存不足");

    private int errCode;
    private String errMsg;

    EmBusinessError(int errCode,String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
    @Override
    public int getErrCode() {
        return this.errCode;
    }
    @Override
    public String getErrMsg() {
        return this.errMsg;
    }
    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }
    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
