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

    //测试
    @RequestMapping("ceshi")
    public List<User> ceshi(User user){
        List<User> users = userService.selUser(user);
        return users;
    }





}
