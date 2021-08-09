package com.msm.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msm.config.Result;
import com.msm.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserMapper  extends BaseMapper<User> {
    List<User> selUser(User user);

    User selectByName(@Param("userName") String userName,@Param("passWord") String passWord);

    List<User> selectUsers(User user);

    int save(User user);

    User selectByNameRegi(@Param("userName") String userName);

    int deleteByUid(@Param("uId") String uId);

    int updateByUid(@Param("uId") String uId);
}
