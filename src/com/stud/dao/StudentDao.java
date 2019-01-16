package com.stud.dao;


import com.stud.domain.Student;

import java.sql.SQLException;
import java.util.List;

/*
* 这是针对学生表的数据访问
*
* */
public interface StudentDao {

    /*
    * 查询所有学生
    * */
    List<Student> findAll()throws SQLException;

    /*
    * 添加学生
    * */
    void insert(Student student) throws SQLException;
}
