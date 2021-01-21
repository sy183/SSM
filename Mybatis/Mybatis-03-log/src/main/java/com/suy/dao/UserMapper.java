package com.suy.dao;

import com.suy.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();
    User getUsersById(int id);
    int insertUser(User user);
    int updateUserPasswdById(Map<String, Object> map);
    int deleteUserById(int id);
}
