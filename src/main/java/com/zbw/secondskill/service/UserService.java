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

    /**
     * @Param [Integer id]
     * @Return com.zbw.secondskill.service.model.UserModel
     * @Description 通过用户ID获取用户对象的方法
     * @Author zbw
     * @Time 2020/3/3 0:19
     */
    UserModel getUserById(Integer id);

    /**
     * @Param [UserModel userModel]
     * @Return void
     * @Description 注册
     * @Author zbw
     * @Time 2020/3/3 0:20
     */
    void register(UserModel userModel) throws BusinessException;

    /**
     * @Param [String telphone,String encrptPassword]
     * @Return com.zbw.secondskill.service.model.UserModel
     * @Description telphone:用户注册手机, password:用户加密后的密码(测试方便起见)
     * @Author zbw
     * @Time 2020/3/3 0:20
     */
    UserModel validateLogin(String telphone,String encrptPassword) throws BusinessException;
}
