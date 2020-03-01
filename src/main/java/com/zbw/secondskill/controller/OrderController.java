package com.zbw.secondskill.controller;

import com.zbw.secondskill.common.enums.ResultEnum;
import com.zbw.secondskill.model.dataobject.UserDo;
import com.zbw.secondskill.model.dto.ResultDTO;
import com.zbw.secondskill.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName OrderController.java
 * @Description //TODO
 * @Author ZBW
 * @Date 2020年03月01日 18:56
 **/
@RestController
@CrossOrigin(allowCredentials = "true", origins = {"*"})
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @PostMapping("/create")
    public ResultDTO createOrder(@RequestParam(name = "itemId") Integer itemId,
                                 @RequestParam(name = "amount") Integer amount) {
        //获取用户的登录信息
        Boolean isLogin = (Boolean) httpServletRequest.getSession().getAttribute("IS_LOGIN");
        if (isLogin == null || !isLogin.booleanValue()) {
            return new ResultDTO(ResultEnum.NOT_LOGIN);
        }
        Integer userId = (Integer) httpServletRequest.getSession().getAttribute("LOGIN_USER");
        System.out.println(userId);
        return orderService.createOrder(userId, itemId, amount);
    }


}
