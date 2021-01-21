package com.suy.pojo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

public class UserTest {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void test() {
        User user = new User(
                1,
                "suy",
                "css66018",
                512
        );
        System.out.print(gson.toJson(user));
    }
}
