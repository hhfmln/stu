package com.stud.servlet;

import com.stud.dao.StudentDao;
import com.stud.dao.impl.StudentDaoImpl;
import com.stud.domain.Student;
import com.stud.service.StudentService;
import com.stud.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


/*
* 负责查询所有的学生信息.然后呈现到list.jsp页面上.
*
* */
@WebServlet(name = "StudentListServlet")
public class StudentListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //查询出来所有的学生
            StudentService service = new StudentServiceImpl();
            List<Student> list = service.findAll();

            //储存到作用域中
            request.setAttribute("list",list);

            System.out.println("版本3");

            //跳转界面
            request.getRequestDispatcher("jsp/list.jsp").forward(request,response);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }


}
