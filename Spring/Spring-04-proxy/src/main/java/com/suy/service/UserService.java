package com.suy.service;

import com.suy.pojo.User;

import java.util.List;

public interface UserService {
    public int insert(User user);
    public int deleteById(int id);
    public int updatePasswdById(int id, String passwd);
    public List<User> select();
}
