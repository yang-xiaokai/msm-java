package com.msm.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msm.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserMapper  extends BaseMapper<User> {
    List<User> selUser(User user);

    User selectByName(@Param("userName") String userName,@Param("passWord") String passWord);

    List<User> selectUsers(User user);

    User selectOne(QueryWrapper<User> queryWrapper);

    void save(User user);

    User selectByNameRegi(@Param("userName") String userName);
}
