package com.stud.service.impl;

import com.stud.dao.StudentDao;
import com.stud.dao.impl.StudentDaoImpl;
import com.stud.domain.Student;
import com.stud.service.StudentService;

import java.sql.SQLException;
import java.util.List;


/*
* 这是学生业务实现
*
* */
public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> findAll() throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        return dao.findAll();
    }

    public void insert(Student student) throws SQLException{
        StudentDao dao = new StudentDaoImpl();
        dao.insert(student);
    }

    @Override
    public void delete(int sid) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        dao.delete(sid);
    }

    @Override
    public Student findStudentById(int sid) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        return dao.findStudentById(sid);

    }

    @Override
    public void update(Student student) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        dao.update(student);
    }
}
