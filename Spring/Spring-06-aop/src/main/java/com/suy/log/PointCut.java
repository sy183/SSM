package com.suy.log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.suy.pojo.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PointCut {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Before("execution(* com.suy.service.UserServiceImpl.select())")
    public void selectBefore() {
        System.out.println("select before");
    }

    @After("execution(* com.suy.service.UserServiceImpl.select())")
    public void selectAfter() {
        System.out.println("select after");
    }

    @Around("execution(* com.suy.service.UserServiceImpl.select())")
    public Object selectAround(ProceedingJoinPoint point) throws Throwable {
        System.out.println("select around before");
        Object o = point.proceed();
        System.out.println("select around after");
        return o;
    }

    @Before("execution(* com.suy.service.UserServiceImpl.insert(..)) && args(user)")
    public void insertBefore(User user) {
        System.out.printf("insert before: %s\n", gson.toJson(user));
    }

    @After("execution(* com.suy.service.UserServiceImpl.insert(..)) && args(user)")
    public void insertAfter(User user) {
        System.out.printf("insert after: %s\n", gson.toJson(user));
    }

    @Around("execution(* com.suy.service.UserServiceImpl.insert(..)) && args(user)")
    public Object insertAround(ProceedingJoinPoint point, User user) throws Throwable {
        System.out.printf("insert around before: %s\n", gson.toJson(user));
        Object o = point.proceed();
        System.out.printf("insert around before: %s\n", gson.toJson(user));
        return o;
    }

    @Before(value = "execution(* com.suy.service.UserServiceImpl.updatePasswdById(..)) && args(id, passwd)", argNames = "id,passwd")
    public void updateBefore(int id, String passwd) {
        System.out.printf("update before: id = %d, passwd = %s\n", id, passwd);
    }

    @After(value = "execution(* com.suy.service.UserServiceImpl.updatePasswdById(..)) && args(id, passwd)", argNames = "id,passwd")
    public void updateAfter(int id, String passwd) {
        System.out.printf("update after: id = %d, passwd = %s\n", id, passwd);
    }

    @Around(value = "execution(* com.suy.service.UserServiceImpl.updatePasswdById(..)) && args(id, passwd)", argNames = "point,id,passwd")
    public Object updateAround(ProceedingJoinPoint point, int id, String passwd) throws Throwable {
        System.out.printf("update around before: id = %d, passwd = %s\n", id, passwd);
        Object o = point.proceed();
        System.out.printf("update around before: id = %d, passwd = %s\n", id, passwd);
        return o;
    }

    @Before("execution(* com.suy.service.UserServiceImpl.deleteById(..)) && args(id)")
    public void deleteBefore(int id) {
        System.out.printf("delete before: %d\n", id);
    }

    @After("execution(* com.suy.service.UserServiceImpl.deleteById(..)) && args(id)")
    public void deleteAfter(int id) {
        System.out.printf("delete after: %d\n", id);
    }

    @Around("execution(* com.suy.service.UserServiceImpl.deleteById(..)) && args(id)")
    public Object deleteAround(ProceedingJoinPoint point, int id) throws Throwable {
        System.out.printf("delete around before: %d\n", id);
        Object o = point.proceed();
        System.out.printf("delete around before: %d\n", id);
        return o;
    }
}
