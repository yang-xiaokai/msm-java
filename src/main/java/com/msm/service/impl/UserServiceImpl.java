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


        return new Result(400,"登录失败","");
    }

    @Override
    public boolean save(User entity) {
        return false;
    }

    @Override
    public boolean saveBatch(Collection<User> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<User> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean removeById(Serializable id) {
        return false;
    }

    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {
        return false;
    }

    @Override
    public boolean remove(Wrapper<User> queryWrapper) {
        return false;
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return false;
    }

    @Override
    public boolean updateById(User entity) {
        return false;
    }

    @Override
    public boolean update(User entity, Wrapper<User> updateWrapper) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<User> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(User entity) {
        return false;
    }

    @Override
    public User getById(Serializable id) {
        return null;
    }

    @Override
    public Collection<User> listByIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public Collection<User> listByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public User getOne(Wrapper<User> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<User> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public int count(Wrapper<User> queryWrapper) {
        return 0;
    }

    @Override
    public List<User> list(Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public IPage<User> page(IPage<User> page, Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public <V> List<V> listObjs(Wrapper<User> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public IPage<Map<String, Object>> pageMaps(IPage<User> page, Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public BaseMapper<User> getBaseMapper() {
        return null;
    }

    @Override
    public boolean saveBatch(Collection<User> entityList) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<User> entityList) {
        return false;
    }

    @Override
    public boolean update(Wrapper<User> updateWrapper) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<User> entityList) {
        return false;
    }

    @Override
    public User getOne(Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<User> list() {
        return null;
    }

    @Override
    public IPage<User> page(IPage<User> page) {
        return null;
    }

    @Override
    public List<Map<String, Object>> listMaps() {
        return null;
    }

    @Override
    public List<Object> listObjs() {
        return null;
    }

    @Override
    public <V> List<V> listObjs(Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public List<Object> listObjs(Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public IPage<Map<String, Object>> pageMaps(IPage<User> page) {
        return null;
    }

    @Override
    public QueryChainWrapper<User> query() {
        return null;
    }

    @Override
    public LambdaQueryChainWrapper<User> lambdaQuery() {
        return null;
    }

    @Override
    public UpdateChainWrapper<User> update() {
        return null;
    }

    @Override
    public LambdaUpdateChainWrapper<User> lambdaUpdate() {
        return null;
    }

    @Override
    public boolean saveOrUpdate(User entity, Wrapper<User> updateWrapper) {
        return false;
    }
}
