package com.zbw.secondskill.service.impl;

import com.sun.tools.internal.ws.wsdl.framework.DuplicateEntityException;
import com.zbw.secondskill.enums.ResultEnum;
import com.zbw.secondskill.model.dataobject.UserPasswordDo;
import com.zbw.secondskill.model.dto.ResultDTO;
import com.zbw.secondskill.dao.UserDoMapper;
import com.zbw.secondskill.dao.UserPasswordDoMapper;
import com.zbw.secondskill.model.dataobject.UserDo;

import com.zbw.secondskill.model.dto.UserDTO;
import com.zbw.secondskill.service.UserService;
import com.zbw.secondskill.utils.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName UserServiceImpl.java
 * @Description //TODO
 * @Author ZBW
 * @Date 2020年02月27日 21:52
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDoMapper userDoMapper;

    @Autowired
    private UserPasswordDoMapper userPasswordDoMapper;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Override
    public ResultDTO getUserById(Integer id) {
        UserDo userDo = userDoMapper.selectByPrimaryKey(id);
        if (userDo == null) {
            return new ResultDTO(ResultEnum.ID_INVALID);
        }
        UserDTO userDTO = new UserDTO();
        //将userDo中的属性拷贝到userModel中的对应属性
        BeanUtils.copyProperties(userDo, userDTO);
        ResultDTO resultDTO = new ResultDTO(ResultEnum.SUCCESS);
        resultDTO.setData(userDTO);
        return resultDTO;
    }

    @Override
    @Transactional
    public ResultDTO register(String name, Byte gender, Integer age, String telephone,String password) {

        if (StringUtils.isEmpty(telephone) || StringUtils.isEmpty(name) ||
        gender == null || age == null) {
            return new ResultDTO(ResultEnum.ILLEGAL_PARAMETER);
        }
        UserDo userDo = new UserDo(name, gender, age, telephone);
        userDo.setRegisterMode("byPhone");
        try {
            userDoMapper.insertSelective(userDo);
        } catch (DuplicateEntityException e) {
            return new ResultDTO(ResultEnum.TELEPHONE_EXISTED);
        }
        String pwd = null;
        try {
            pwd = MD5Utils.EncodeByMD5(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new ResultDTO(ResultEnum.PASSWORD_EXCEPTION);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new ResultDTO(ResultEnum.PASSWORD_EXCEPTION);
        }
        UserPasswordDo userPasswordDo = new UserPasswordDo(pwd,userDo.getId());
        userPasswordDoMapper.insertSelective(userPasswordDo);
        return new ResultDTO(ResultEnum.SUCCESS);
    }

    @Override
    public ResultDTO login(String telephone, String password) {
        //通过用户手机获取用户信息
        UserDo userDo = userDoMapper.selectByTelephone(telephone);
        if (userDo == null) {
            return new ResultDTO(ResultEnum.LOGIN_FAIL);
        }
        UserPasswordDo userPasswordDo = userPasswordDoMapper.selectByUserId(userDo.getId());
        //比对用户信息内的加密密码是否和传输进来的密码相互匹配
        String pwd = null;
        try {
            pwd = MD5Utils.EncodeByMD5(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(pwd);
        if ( !pwd.equals(userPasswordDo.getEncrptPassword()) ) {
            return new ResultDTO(ResultEnum.LOGIN_FAIL);
        }
        this.httpServletRequest.getSession().setAttribute("IS_LOGIN", true);
        this.httpServletRequest.getSession().setAttribute("LOGIN_USER", userDo.getId());
        return new ResultDTO(ResultEnum.SUCCESS);
    }
}
