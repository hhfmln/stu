package com.stud.dao.impl;

import com.stud.dao.StudentDao;
import com.stud.domain.Student;
import com.stud.util.JDBCUtil02;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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

    @Override
    public void delete(int sid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        runner.update("delete from stu where sid=?",sid);
    }

    @Override
    public Student findStudentById(int sid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        return runner.query("select * from stu where sid = ?",new BeanHandler<Student>(Student.class),sid);
    }

    @Override
    public void update(Student student) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        runner.update("update stu set sname = ?, gender = ?, phone = ?,birthday = ?, hobby = ?, info = ? where sid = ?",
                student.getSname(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo(),
                student.getSid());
    }
}
