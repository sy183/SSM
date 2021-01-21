package com.suy.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.suy.pojo.User;
import com.suy.proxy.ProxyInvocationHandler;
import com.suy.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserClientTest {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProxyInvocationHandler handler = (ProxyInvocationHandler)
                context.getBean("proxyInvocationHandler");
        UserService proxy = (UserService) handler.getProxy();
        System.out.println(gson.toJson(proxy.updatePasswdById(2, "ffffff")));
        System.out.println(gson.toJson(proxy.insert(new User(4, "hong", "admin", 256))));
        System.out.println(gson.toJson(proxy.select()));
    }
}
