package com.suy.service;

import com.suy.dao.UserDao;
import com.suy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public int deleteById(int id) {
        return userDao.deleteById(id);
    }

    @Override
    public int updatePasswdById(int id, String passwd) {
        return userDao.updatePasswdById(id, passwd);
    }

    @Override
    public List<User> select() {
        return userDao.select();
    }
}
