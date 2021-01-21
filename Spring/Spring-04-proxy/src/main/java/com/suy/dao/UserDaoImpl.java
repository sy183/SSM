package com.suy.dao;

import com.suy.database.Database;
import com.suy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    private Database database;

    public Database getDatabase() {
        return database;
    }

    @Autowired
    public void setDatabase(Database database) {
        this.database = database;
    }

    @Override
    public int insert(User user) {
        return database.insert(user);
    }

    @Override
    public int deleteById(int id) {
        return database.deleteById(id);
    }

    @Override
    public int updatePasswdById(int id, String passwd) {
        return database.updatePasswdById(id, passwd);
    }

    @Override
    public List<User> select() {
        return database.select();
    }
}
