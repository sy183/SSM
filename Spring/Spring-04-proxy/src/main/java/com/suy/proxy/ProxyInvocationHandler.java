package com.suy.proxy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.suy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class ProxyInvocationHandler implements InvocationHandler {
    private UserService userService;
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                userService.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.printf("invoke method %s%s\n",
                method.getName(), args == null ? "" : " " + gson.toJson(args));
        return method.invoke(userService, args);
    }
}
