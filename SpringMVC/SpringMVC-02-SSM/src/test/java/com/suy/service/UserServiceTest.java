package com.suy.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.suy.config.AppConfig;
import com.suy.pojo.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserServiceTest {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Logger logger = LogManager.getLogger();
    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService) context.getBean("userServiceImpl");

        User curUser = userService.getUserById(1);

//        Map<String, Object> updateMap = new HashMap<>();
//        updateMap.put("id", 4);
//        updateMap.put("passwd", "123456");
//        updateMap.put("privilege", 2);
//
//        userService.updateUser(curUser, updateMap);

        curUser = userService.getUserById(1);
//        userService.insertUser(curUser, new User("css", "ffffff", 2));
        userService.deleteUserById(curUser, 8);

        //logger.info(gson.toJson(userList));
    }
}
