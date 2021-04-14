package com.msm.controller;

import com.github.pagehelper.PageHelper;
import com.msm.config.Result;
import com.msm.entity.User;
import com.msm.service.UserService;
import com.msm.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.MD5;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);


    //注入
    @Autowired
    private UserService userService;

    //测试框架
    @PostMapping(value = "/test")
    @ResponseBody
    public List<User> ceshi(User user){
        List<User> u=userService.selectUsers(user);
        return  u;
    }

    //登录用户
    @PostMapping(value = "/login")
    @CrossOrigin
    public Result login(@RequestBody User user){
        String userName = user.getUserName();
        String passWord = user.getPassWord();
        logger.info("userName:"+userName+"  password:"+passWord);
        return userService.login(user);

    }

    @PostMapping(value = "/register")
    public Result register(@RequestBody User user){
        String userName = user.getUserName();
        String passWord = user.getPassWord();
        logger.info("userName:"+userName+"  password:"+passWord);

        return  userService.insert(user);
    }
    //查询用户
    @PostMapping(value = "/selectOneByName")
    public  Result selectOneByName(@RequestBody User user){
        String userName = user.getUserName();
        String passWord = user.getPassWord();
        User u = userService.selectByName(userName,passWord);
        if(u!=null){
            logger.info("userName:"+userName);
            return  new Result(200,"查询成功",u);
        }

        return  new Result(400,"查询失败","该用户不存在");
    }
    //根据用户查询数据
    //admin是全查   其余的只显示本人的










}
