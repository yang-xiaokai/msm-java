package com.msm.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.msm.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper  {
    List<User> selUser(User user);

    int selectByName(String userName);
}
