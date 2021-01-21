package com.suy.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.suy.pojo.User;
import com.suy.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Logger logger = LogManager.getLogger();

    @Test
    public void test() {
        try (SqlSession sqlSession = MybatisUtil.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            logger.info("select * from user");
            List<User> userList = userMapper.getUserList();
            logger.info(gson.toJson(userList));

            logger.info("select * from user where id = 1");
            User user = userMapper.getUsersById(1);
            logger.info(gson.toJson(user));

            logger.info("insert into user (id, user, passwd, privilege) values (3, '李四', 'ffffff', 1024)");
            userMapper.insertUser(new User(3, "李四", "ffffff", 1024));
            sqlSession.commit();

            logger.info("select * from user");
            userList = userMapper.getUserList();
            logger.info(gson.toJson(userList));

            logger.info("update user set passwd = '666666' where id = 2");
            Map<String, Object> map = new HashMap<>();
            map.put("id", 2);
            map.put("passwd", "666666");
            userMapper.updateUserPasswdById(map);
            sqlSession.commit();

            logger.info("select * from user");
            userList = userMapper.getUserList();
            logger.info(gson.toJson(userList));

            logger.info("delete from user where id = 3");
            userMapper.deleteUserById(3);
            sqlSession.commit();

            logger.info("select * from user");
            userList = userMapper.getUserList();
            logger.info(gson.toJson(userList));

            logger.info("update user set passwd = '123456' where id = 2");
            map = new HashMap<>();
            map.put("id", 2);
            map.put("passwd", "123456");
            userMapper.updateUserPasswdById(map);
            sqlSession.commit();

            logger.info("select * from user");
            userList = userMapper.getUserList();
            logger.info(gson.toJson(userList));

        }
    }
}