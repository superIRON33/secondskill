package com.zbw.secondskill.controller;

import com.zbw.secondskill.enums.ResultEnum;
import com.zbw.secondskill.model.dto.ResultDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName BaseController.java
 * @Description //TODO
 * @Author ZBW
 * @Date 2020年02月28日 12:21
 **/
public class BaseController {
    //定义exceptionhandler解决未被controller层吸收的exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex) {
        ResultDTO resultDTO = new ResultDTO(ResultEnum.FAILED);
        resultDTO.setData(ex);
        return resultDTO;
    }
}
