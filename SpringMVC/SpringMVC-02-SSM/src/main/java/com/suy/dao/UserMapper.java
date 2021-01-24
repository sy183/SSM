package com.suy.dao;

import com.suy.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> getUsers();
    User getUserById(int id);
    List<User> getUsersByName(String name);
    List<User> getUsersByPrivilege(int privilege);

    User getUserByNameAndPasswd(@Param("name") String name, @Param("passwd") String passwd);

    int insertUser(User user);
    int deleteUserById(int id);
    int updateUser(User user);
}
