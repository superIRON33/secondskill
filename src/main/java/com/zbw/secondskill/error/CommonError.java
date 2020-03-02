package com.zbw.secondskill.error;

/**
 * @ClassName CommonError.java
 * @Description //包装器业务异常接口
 * @Author ZBW
 * @Date 2020年02月29日 13:55
 **/
public interface CommonError {
    public int getErrCode();
    public String getErrMsg();
    public CommonError setErrMsg(String errMsg);


}
