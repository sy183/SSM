package com.suy.database;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DatabaseTest {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Database database = context.getBean("database", Database.class);
        System.out.println(gson.toJson(database.getUserList()));
    }
}
