package com.msm.service;

import com.baomidou.mybatisplus.service.IService;
import com.msm.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService  {
     List<User> selUser(User user);

     int selectByName(String userName);
}
