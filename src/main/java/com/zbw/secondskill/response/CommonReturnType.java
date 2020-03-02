package com.zbw.secondskill.response;

import lombok.Data;

/**
 * @ClassName CommonReturnType.java
 * @Description //通用返回类型
 * @Author ZBW
 * @Date 2020年02月29日 22:09
 **/
@Data
public class CommonReturnType {
    /**
     * 表明对应请求的返回处理结果 "success" 或 "fail"
     */
    private String status;

    /**
     * 若status=success,则data内返回前端需要的json数据
     * 若status=fail，则data内使用通用的错误码格式
     */
    private Object data;

    /**
     * @Param [Object result]
     * @Return com.zbw.secondskill.error.CommonReturnType
     * @Description 定义一个通用的创建方法
     * @Author zbw
     * @Time 2020/3/2 23:33
     */
    public static CommonReturnType create (Object result){
        return CommonReturnType.create(result,"success");
    }

    /**
     * @Param [Object result, String status]
     * @Return com.zbw.secondskill.error.CommonReturnType
     * @Description 定义一个通用的创建方法
     * @Author zbw
     * @Time 2020/3/2 23:33
     */
    public static CommonReturnType create (Object result, String status){
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }
}
