package com.msm.service.impl;


import com.msm.entity.User;
import com.msm.mapper.UserMapper;
import com.msm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Resource
    private UserMapper userMapper;



    @Override
    public List<User> selUser(User user) {
        return userMapper.selUser(user);
    }

    @Override
    public int selectByName(String userName) {
        return userMapper.selectByName(userName);
    }
}
