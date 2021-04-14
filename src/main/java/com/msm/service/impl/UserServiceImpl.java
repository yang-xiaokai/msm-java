package com.msm.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.UpdateChainWrapper;
import com.msm.config.Result;
import com.msm.entity.User;
import com.msm.mapper.UserMapper;
import com.msm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selUser(User user) {
        return userMapper.selUser(user);
    }

    @Override
    public User selectByName(String userName,String passWord) {

        return userMapper.selectByName(userName,passWord);
    }

    @Override
    public List<User> selectUsers(User user) {
        return userMapper.selectUsers(user);
    }

    @Override
    public Result login(User user) {
        if (StringUtils.isEmpty(user.getUserName())){
            System.out.println(user.getUserName());
            return new Result(400,"用户名不能为空","");
        }
        if (StringUtils.isEmpty(user.getPassWord())){
            System.out.println(user.getPassWord());
            return new Result(400,"密码不能为空","");
        }
        //查询用户
//        QueryWrapper<User> wrapper = new QueryWrapper();
//        wrapper.eq("userName",user.getUserName());
        String userName = user.getUserName();
        String passWord = user.getPassWord();
        User us = userMapper.selectByName(userName,passWord);
        if(us!=null){

            return new Result(200,"登录成功",us);

        }


        return new Result(400,"登录失败","用户名密码错误");
    }

    @Override
    public Result insert(User user) {
        if (StringUtils.isEmpty(user.getUserName())){
            System.out.println(user.getUserName());
            return new Result(400,"用户名不能为空","");
        }
        if (StringUtils.isEmpty(user.getPassWord())){
            System.out.println(user.getPassWord());
            return new Result(400,"密码不能为空","");
        }
        user.setUserName(user.getUserName());
        user.setPassWord(user.getPassWord());
        user.setLoginTime(new Date());
        user.setLastTime(new Date());
        user.setUserEmail(user.getUserEmail());
        user.setUserTel(user.getUserTel());
        userMapper.save(user);


        return new Result(200,"注册成功","");
    }
}
