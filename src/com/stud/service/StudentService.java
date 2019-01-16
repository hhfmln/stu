package com.stud.service;

import com.stud.domain.Student;

import java.sql.SQLException;
import java.util.List;


/*
* 这是学生的业务处理规范
*
* */
public interface StudentService {
    /*
    * 查询学生
    * */
    List<Student> findAll()throws SQLException;
    /*
     * 添加学生
     * */
    void insert(Student student) throws SQLException;
}
