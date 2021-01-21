package com.suy.database;

import com.suy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Database {
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    @Autowired
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int insert(User user) {
        userList.add(user);
        return 1;
    }

    public int deleteById(int id) {
        return userList.removeIf(user -> user.getId() == id) ? 1 : 0;
    }

    public int updatePasswdById(int id, String passwd) {
        AtomicInteger count = new AtomicInteger();
        userList.forEach(user -> {
            if (user.getId() == id) {
                user.setPasswd(passwd);
                count.getAndIncrement();
            }
        });
        return count.get();
    }

    public List<User> select() {
        return userList;
    }
}
