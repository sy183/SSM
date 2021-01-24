package com.suy.service;

import com.suy.pojo.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUserById(int id);
    List<User> getUsersByName(String name);
    List<User> getUsersByPrivilege(int privilege);

    User login(String name, String passwd);

    int insertUser(User curUser, User newUser);
    int deleteUserById(User curUser, int id);
    int updateUser(User curUser, User user);
}
