package com.msm.controller;

import com.msm.entity.User;
import com.msm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    //注入
    @Resource
    private UserService userService;

    //测试框架
    @RequestMapping("ceshi")
    public List<User> ceshi(User user){
        List<User> users = userService.selUser(user);
        return users;
    }
    //登录用户


    //注册用户(判断用户名是否存在,存在则提示,不存在则注册)


    //注销用户







}
