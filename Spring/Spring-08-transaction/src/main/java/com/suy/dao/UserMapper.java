package com.suy.dao;

import com.suy.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();
    int insertUser(User user);
    int deleteUserById(int id);
    int insertUserAndDeleteUserById(User user, int id);
}
