package com.suy.dao;

import com.suy.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getStudentsByJoin();
    List<Student> getStudentsBySubSelect();
}
