package com.zbw.secondskill.common.validator;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ValidationResult.java
 * @Description //Validator校验结果类
 * @Author ZBW
 * @Date 2020年02月29日 16:12
 **/
@Data
public class ValidationResult {
    /**
     * 校验结果是否有错
     */
    private boolean hasErrors = false;

    /**
     * 存放错误信息的Map
     */
    private Map<String, String> errorMsgMap = new HashMap<>();


    /**
     * @Param []
     * @Return String
     * @Description 实现通用的通过格式化字符串获取错误结果的msg方法
     * @Author zbw
     * @Time 2020/2/29 16:14
     */
    public String getErrMsg() {
        return StringUtils.join(errorMsgMap.values().toArray(),",");
    }

}
