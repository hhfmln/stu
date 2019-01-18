package com.stud.servlet;

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

/*
* 处理单个学生的更新，查询一个学生的信息，然后跳转到更新页面
* */
@WebServlet(name = "EditServlet")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            //接受id
            int sid = Integer.parseInt(request.getParameter("sid"));

            //查询学生数据
            StudentService service = new StudentServiceImpl();
            Student stu = service.findStudentById(sid);
            System.out.println(stu.getBirthday());

            //显示数据
            //存数据
            request.setAttribute("stu",stu);
            request.getRequestDispatcher("edit.jsp").forward(request,response);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
