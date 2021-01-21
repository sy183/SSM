package com.suy.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Information {
    private String name;
    private int age;
    private String sex;

    public Information() {
    }

    public Information(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    @Value("suy")
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Value("18")
    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    @Value("male")
    public void setSex(String sex) {
        this.sex = sex;
    }
}
