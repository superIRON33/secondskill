package com.zbw.secondskill.service;


import com.zbw.secondskill.error.BusinessException;
import com.zbw.secondskill.service.model.UserModel;

/**
 * @ClassName UserService.java
 * @Description //用户服务Service接口
 * @Author ZBW
 * @Date 2020年02月27日 21:51
 **/
public interface UserService {
    //通过用户ID获取用户对象的方法
    UserModel getUserById(Integer id);
    void register(UserModel userModel) throws BusinessException;

    /*
    telphone:用户注册手机
    password:用户加密后的密码
     */
    UserModel validateLogin(String telphone,String encrptPassword) throws BusinessException;
}
