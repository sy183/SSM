package com.suy.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

public class MySqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "mybatis-config.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }

    public static SqlSession openSession(boolean b) {
        return sqlSessionFactory.openSession(b);
    }

    public static SqlSession openSession(Connection connection) {
        return sqlSessionFactory.openSession(connection);
    }

    public static SqlSession openSession(TransactionIsolationLevel transactionIsolationLevel) {
        return sqlSessionFactory.openSession(transactionIsolationLevel);
    }

    public static SqlSession openSession(ExecutorType executorType) {
        return sqlSessionFactory.openSession(executorType);
    }

    public static SqlSession openSession(ExecutorType executorType, boolean b) {
        return sqlSessionFactory.openSession(executorType, b);
    }

    public static SqlSession openSession(ExecutorType executorType, TransactionIsolationLevel transactionIsolationLevel) {
        return sqlSessionFactory.openSession(executorType, transactionIsolationLevel);
    }

    public static SqlSession openSession(ExecutorType executorType, Connection connection) {
        return sqlSessionFactory.openSession(executorType, connection);
    }

    public static Configuration getConfiguration() {
        return sqlSessionFactory.getConfiguration();
    }
}
