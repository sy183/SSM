package com.suy.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.suy.pojo.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserMapperTest {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Logger logger = LogManager.getLogger();
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = (UserMapper) context.getBean("userMapperImpl");
        List<User> userList = userMapper.getUserList();
        logger.info(gson.toJson(userList));

        userMapper.insertUserAndDeleteUserById(new User(3, "小刘", "queue", 128), 3);

    }
}
