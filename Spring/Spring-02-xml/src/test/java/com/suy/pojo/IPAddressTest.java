package com.suy.pojo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IPAddressTest {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("IPAddress.xml");
        IPAddress ip13 = context.getBean("10.16.50.13", IPAddress.class);
        IPAddress ip14 = context.getBean("10.16.50.14", IPAddress.class);
        System.out.println(gson.toJson(ip13));
        System.out.println(gson.toJson(ip14));
    }
}
