package com.msm.service.impl;

import com.msm.config.Result;
import com.msm.entity.User;
import com.msm.mapper.UserMapper;
import com.msm.service.UserService;
import com.msm.util.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;


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

        String userName = user.getUserName();
        String passWord = user.getPassWord();
        User i=userMapper.selectByName(userName,Md5Utils.md5(passWord));
        if(StringUtils.isEmpty(i)){

            return new Result(400,"登录失败","用户名不存在");
        }
        return new Result(200,"登录成功",user);
    }

    @Override
    @Transactional
    public Result insert(User user) {
        String userName = user.getUserName();
        //去数据库查询用户名是否存在
        User user1 = userMapper.selectByNameRegi(userName);

        if(user1!=null){

            return new Result(400,"用户名重复","");
        }
        User userna= new User();
        userna.setUserName(userName);
        userna.setPassWord(Md5Utils.md5(user.getPassWord()));
        userna.setLoginTime(new Date());
        userna.setLastTime(new Date());
        userna.setUserEmail(user.getUserEmail());
        userna.setUserTel(user.getUserTel());
        int save = userMapper.save(userna);
        if(StringUtils.isEmpty(save)){
            return new Result(400,"注册失败","");
        }

        return new Result(200,"注册成功",userna);

    }

    @Override
    public int deleteByid(String uId) {
        return userMapper.deleteByUid(uId);
    }

    @Override
    public Result updateByUid(User user) {
        String uId = user.getuId();
        user.setUserName(user.getUserName());
        user.setUserEmail(user.getUserEmail());
        user.setUserTel(user.getUserTel());
        user.setLastTime(new Date());
        int up=userMapper.updateByUid(uId);
        if(StringUtils.isEmpty(up)){
            return new Result(400,"修改失败","");
        }

        return new Result(200,"修改成功",user);
    }
}
