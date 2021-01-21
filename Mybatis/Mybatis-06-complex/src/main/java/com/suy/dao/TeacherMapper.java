package com.suy.dao;

import com.suy.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> getTeachersByJoin();
    List<Teacher> getTeachersBySubSelect();
}
