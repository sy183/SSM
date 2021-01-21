package com.suy.dao;

import com.suy.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();
    List<User> getUserListLimit(Map<String, Integer> map);
}
