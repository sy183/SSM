package com.suy.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.suy.pojo.User;
import com.suy.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void test() {
        try (SqlSession sqlSession = MybatisUtil.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            System.out.println("select * from user");
            List<User> userList = userMapper.getUserList();
            System.out.println(gson.toJson(userList));

            System.out.println("select * from user where id = 1");
            User user = userMapper.getUsersById(1);
            System.out.println(gson.toJson(user));

            System.out.println("insert into user (id, user, passwd, privilege) values (3, '李四', 'ffffff', 1024)");
            userMapper.insertUser(new User(3, "李四", "ffffff", 1024));
            sqlSession.commit();

            System.out.println("select * from user");
            userList = userMapper.getUserList();
            System.out.println(gson.toJson(userList));

            System.out.println("update user set passwd = '666666' where id = 2");
            Map<String, Object> map = new HashMap<>();
            map.put("id", 2);
            map.put("passwd", "666666");
            userMapper.updateUserPasswdById(map);
            sqlSession.commit();

            System.out.println("select * from user");
            userList = userMapper.getUserList();
            System.out.println(gson.toJson(userList));

            System.out.println("delete from user where id = 3");
            userMapper.deleteUserById(3);
            sqlSession.commit();

            System.out.println("select * from user");
            userList = userMapper.getUserList();
            System.out.println(gson.toJson(userList));

            System.out.println("update user set passwd = '123456' where id = 2");
            map = new HashMap<>();
            map.put("id", 2);
            map.put("passwd", "123456");
            userMapper.updateUserPasswdById(map);
            sqlSession.commit();

            System.out.println("select * from user");
            userList = userMapper.getUserList();
            System.out.println(gson.toJson(userList));

        }
    }
}