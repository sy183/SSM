package com.suy.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.suy.pojo.User;
import com.suy.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserClientTest {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userServiceImpl");
        userService.select();
        userService.insert(new User(4, "hong", "666666", 256));
        userService.updatePasswdById(2, "ffffff");
        userService.deleteById(3);
    }
}
