package com.suy.pojo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.suy.config.Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.LinkedList;
import java.util.List;

public class UserTest {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        List<User> userList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            User user = context.getBean("user", User.class);
            user.setId(i);
            user.getInformation().setAge(i + 18);
            userList.add(user);
        }
        System.out.println(gson.toJson(userList));
    }

    @Test
    public void testAnno() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        User user = context.getBean("getUser", User.class);
        System.out.println(gson.toJson(user));
    }
}
