package com.msm.service;

import com.msm.config.Result;
import com.msm.entity.User;
import org.springframework.transaction.annotation.Transactional;


import java.beans.Transient;
import java.util.List;
@Transactional
public interface UserService  {
     List<User> selUser(User user);

     User selectByName(String userName,String passWord);

     List<User> selectUsers(User user);
     Result login(User user);

    Result insert(User user);

    int deleteByid(String uId);

    Result updateByUid(User user);
//Result register(User user);
}
