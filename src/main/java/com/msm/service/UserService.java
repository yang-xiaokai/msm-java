package com.msm.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.msm.config.Result;
import com.msm.entity.User;


import java.util.List;

public interface UserService  {
     List<User> selUser(User user);

     User selectByName(String userName,String passWord);

     List<User> selectUsers(User user);

    public Result login(User user);

    Result insert(User user);

    //Result register(User user);
}
