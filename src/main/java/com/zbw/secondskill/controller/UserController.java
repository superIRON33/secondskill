package com.zbw.secondskill.controller;

import com.zbw.secondskill.model.dto.ResultDTO;
import com.zbw.secondskill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController.java
 * @Description //用户Controller
 * @Author ZBW
 * @Date 2020年02月27日 21:49
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public ResultDTO getUser(@RequestParam(name = "id") Integer id) {
        return userService.getUserById(id);
    }

}
