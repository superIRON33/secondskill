package com.zbw.secondskill.validator;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ValidationResult.java
 * @Description //参数校验结果配置
 * @Author ZBW
 * @Date 2020年02月29日 22:46
 **/
@Data
public class ValidationResult {
    /**
     * 校验结果是否有错
     */
    private boolean hasErrors = false;

    /**
     * 存放错误信息的map
     */
    private Map<String,String> errorMsgMap = new HashMap<>();

    /**
     * @Param []
     * @Return String
     * @Description 实现通用的通过格式化字符串信息获取错误结果的msg方法
     * @Author zbw
     * @Time 2020/3/3 0:24
     */
    public String getErrMsg(){
        return StringUtils.join(errorMsgMap.values().toArray(),",");
    }
}
