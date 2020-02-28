package com.zbw.secondskill.controller;

import com.zbw.secondskill.enums.ResultEnum;
import com.zbw.secondskill.model.dto.ResultDTO;
import com.zbw.secondskill.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * @ClassName UserController.java
 * @Description //用户Controller
 * @Author ZBW
 * @Date 2020年02月27日 21:49
 **/
@RestController
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    //内部为单例模式，但是有ThreadLocal的保护
    private HttpServletRequest httpServletRequest;

    //用户注册接口
    @PostMapping("/register")
    public ResultDTO register(@RequestParam(name = "telephone") String telephone,
                              @RequestParam(name = "otpCode") String otpCode,
                              @RequestParam(name = "name") String name,
                              @RequestParam(name = "gender") Byte gender,
                              @RequestParam(name = "age") Integer age,
                              @RequestParam(name = "password") String password) {
        //验证手机号和对应的otpCode相符合
        String inSessionOtpCode = (String) this.httpServletRequest.getSession().getAttribute(telephone);
        //该equals内部已经做的判空处理
        if (com.alibaba.druid.util.StringUtils.equals(otpCode, inSessionOtpCode)) {
            return new ResultDTO(ResultEnum.OPT_INVALID);
        }

        //调用用户注册service
        return userService.register(name, gender, age, telephone, password);
    }

    @GetMapping("/get")
    public ResultDTO getUser(@RequestParam(name = "id") Integer id) {
        return userService.getUserById(id);
    }

    //用户获取otp短信接口
    @PostMapping("/getotp")
    public ResultDTO getOtp(@RequestParam(name = "telephone") String telephone) {
        //需要按照一定的规则生成Otp验证码
        Random random = new Random();
        int randInt = random.nextInt(99999);
        randInt += 10000;
        String otpCode = String.valueOf(randInt);
        //将otp验证码同对应用户的手机号关联(按照分布式的思想来讲，可以做在redis中，就算用户反复点击请求opt，那么在redis中就直接可以不断进行覆盖)
        //暂且先使用httpsession的方式绑定手机号与optCode
        httpServletRequest.getSession().setAttribute(telephone, otpCode);
        System.out.println("telephone: " + telephone + "& otpCode :" + otpCode);
        //将otp验证码通过短信通道发送给用户，暂且省略
        ResultDTO resultDTO = new ResultDTO(ResultEnum.SUCCESS);
        resultDTO.setData(otpCode);
        return resultDTO;
    }

    @PostMapping("/login")
    public ResultDTO login(@RequestParam(name = "telephone") String telephone,
                           @RequestParam(name = "password") String password) {
        if (StringUtils.isEmpty(telephone) || StringUtils.isEmpty(password)) {
            return new ResultDTO(ResultEnum.ILLEGAL_PARAMETER);
        }

        //用户登陆服务
        return userService.login(telephone, password);
    }

}
