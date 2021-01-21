package com.suy.dao;

import com.suy.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {
    @Override
    public List<User> getUserList() {
        return getSqlSession().getMapper(UserMapper.class).getUserList();
    }

    @Override
    public int insertUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).insertUser(user);
    }

    @Override
    public int deleteUserById(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUserById(id);
    }

    @Override
    @Transactional
    public int insertUserAndDeleteUserById(User user, int id) {
        int ret = 0;
        ret += insertUser(user);
        ret += deleteUserById(id);
        return ret;
    }
}
