package com.zbw.secondskill.service;


import com.zbw.secondskill.model.dto.ResultDTO;

/**
 * @ClassName UserService.java
 * @Description //TODO
 * @Author ZBW
 * @Date 2020年02月27日 21:51
 **/
public interface UserService {

    /**
     * @Param [id]
     * @Return void
     * @Description 通过用户id获取用户对象的方法
     * @Author zbw
     * @Time 2020/2/27 21:54
     * @return
     */
    ResultDTO getUserById(Integer id);
}
