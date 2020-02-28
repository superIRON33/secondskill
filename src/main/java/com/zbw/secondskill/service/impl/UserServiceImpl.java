package com.zbw.secondskill.service.impl;

import com.zbw.secondskill.enums.ResultEnum;
import com.zbw.secondskill.model.dto.ResultDTO;
import com.zbw.secondskill.dao.UserDoMapper;
import com.zbw.secondskill.dao.UserPasswordDoMapper;
import com.zbw.secondskill.model.dataobject.UserDo;

import com.zbw.secondskill.model.viewObject.UserDTO;
import com.zbw.secondskill.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
