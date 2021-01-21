package com.suy.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.suy.pojo.Student;
import com.suy.pojo.Teacher;
import com.suy.util.MySqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class AddressBookMapperTest {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Logger logger = LogManager.getLogger();

    @Test
    public void test() {
        try (SqlSession sqlSession = MySqlSessionFactory.openSession(true)) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> students = studentMapper.getStudentsBySubSelect();
            logger.info(gson.toJson(students));

            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            List<Teacher> teachers = teacherMapper.getTeachersBySubSelect();
            logger.info(gson.toJson(teachers));
        }
    }
}