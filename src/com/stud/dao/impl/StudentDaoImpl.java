package com.stud.dao.impl;

import com.stud.dao.StudentDao;
import com.stud.domain.Student;
import com.stud.util.JDBCUtil02;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {


    /*
    * 查询所有学生
    * */
    @Override
    public List<Student> findAll() throws SQLException{
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        return runner.query("select * from stu",new BeanListHandler<Student>(Student.class));
    }

    public void insert(Student student) throws SQLException{
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());

        runner.update("insert into stu values (null,?,?,?,?,?,?)",
                student.getSname(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo()
                );
    }
}
