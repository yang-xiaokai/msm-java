package com.msm.controller;

import com.fundebug.Fundebug;
import com.msm.config.Result;
import com.msm.entity.User;
import com.msm.service.UserService;
import com.msm.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    //注入
    @Autowired
    private UserService userService;

    //测试框架
    @PostMapping(value = "/test")
    @ResponseBody
    public List<User> ceshi(User user) {
        List<User> u = userService.selectUsers(user);
        return u;
    }

    //登录用户
    @RequestMapping(value = "/login")
    @CrossOrigin("http://localhost:8080")
    public Result login(@RequestBody User user) {
        String userName = user.getUserName();
        String passWord = user.getPassWord();
        logger.info("userName:" + userName + "  password:" + passWord);
        //User user1=userService.loginUser(user);


        return userService.login(user);

    }

    @RequestMapping(value = "/register")
    public Result register(@RequestBody User user) {
        if (StringUtils.isEmpty(user.getUserName())){
            System.out.println(user.getUserName());
            return new Result(400,"用户名不能为空","");
        }
        if (StringUtils.isEmpty(user.getPassWord())){
            System.out.println(user.getPassWord());
            return new Result(400,"密码不能为空","");
        }
        return userService.insert(user);
    }

    //查询用户
    @RequestMapping(value = "/selectOneByName")
    public Result selectOneByName(@RequestBody User user) {
        String userName = user.getUserName();
        String passWord = user.getPassWord();
        User u = userService.selectByName(userName, passWord);
        if (u != null) {
            logger.info("userName:" + userName);
            return new Result(200, "查询成功", u);
        }

        return new Result(400, "查询失败", "该用户不存在");
    }
    //根据用户查询数据
    //admin是全查   其余的只显示本人的


    //用户信息修改
    @RequestMapping(value = "/deleteById")
    public Result deleteById(@RequestParam("uId") String uId) {
        logger.info("用户id为:" + uId);
        System.out.println(uId);
        try {

            int i = userService.deleteByid(uId);
            System.out.println(uId);
            System.out.println(i);
            if(i>0){
                return new Result(200, "删除成功", i);
            }

        } catch (Exception e) {
            logger.error("错误异常");
        }

        return  new Result(400,"删除失败","");
    }


    //修改用户信息
//    @PostMapping(value = "/updateById")
//    public Result updateById(@RequestBody User user){
//        String s = user.getuId();
//        return  new Result()
//    }

    //修改

    @RequestMapping("/updateByUid")
    public Result updateByUid(@RequestBody User user){
        String s = user.getuId();
        if (StringUtils.isEmpty(s)){
            return new Result(400,"用户id为空","");
        }

        return userService.updateByUid(user);
    }


    //@PostMapping(value = "/nihao")
    @GetMapping("/nihao")
    public String nihao(User user) {

        return "hello world";
    }














}
