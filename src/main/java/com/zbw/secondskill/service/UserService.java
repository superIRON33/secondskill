package com.zbw.secondskill.service;


import com.zbw.secondskill.model.dto.ResultDTO;

/**
 * @ClassName UserService.java
 * @Description //用户服务Service接口
 * @Author ZBW
 * @Date 2020年02月27日 21:51
 **/
public interface UserService {

    /**
     * @Param [Integer id]
     * @Return com.zbw.secondskill.model.dto.ResultDTO
     * @Description 通过用户id获取用户对象的方法
     * @Author zbw
     * @Time 2020/2/27 21:54
     * @return
     */
    ResultDTO getUserById(Integer id);

    /**
     * @Param [String name, Byte gender, Integer age, String telephone, String password]
     * @Return com.zbw.secondskill.model.dto.ResultDTO
     * @Description 实现用户注册
     * @Author zbw
     * @Time 2020/2/29 22:58
     */
    ResultDTO register(String name, Byte gender, Integer age, String telephone, String password);

    /**
     * @Param [String telephone, String password]
     * @Return com.zbw.secondskill.model.dto.ResultDTO
     * @Description 实现用户登陆
     * @Author zbw
     * @Time 2020/2/29 22:59
     */
    ResultDTO login(String telephone, String password);
}
