package com.zbw.secondskill.model.dto;

import com.zbw.secondskill.common.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Auther: wjy
 * @Date: 2019/11/14 12:31
 * @Description: 封装返回给前端的数据
 */
@Data
@AllArgsConstructor
public class ResultDTO {

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 状态消息
     */
    private String message;
    /**
     * 封装的数据
     */
    private Object data;

    public ResultDTO(ResultEnum result) {
        setResultEnum(result);
    }

    public void setResultEnum(ResultEnum result) {
        
        this.code = result.getCode();
        this.message = result.getMessage();
    }
}