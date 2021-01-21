package com.suy.log;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component
public class Logger implements MethodBeforeAdvice, AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println(o + " " + method.getName() + " " + Arrays.toString(objects) + " " + o1);
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(method.getName() + " " + Arrays.toString(objects) + " " + o);
    }
}
