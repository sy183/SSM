package com.suy.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.suy.pojo.User;
import com.suy.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Logger logger = LogManager.getLogger();

    @Test
    public void test() {
        try (SqlSession sqlSession = MybatisUtil.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Integer> scope = new HashMap<>();
            int start = 0;
            final int size = 2;

            while (true) {
                scope.put("start", start);
                scope.put("size", size);
                List<User> userList = userMapper.getUserListLimit(scope);
                if (userList == null || userList.size() == 0) {
                    break;
                }
                logger.info(gson.toJson(userList));
                start += userList.size();
            }
        }
    }
}