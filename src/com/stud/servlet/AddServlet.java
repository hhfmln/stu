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
import java.util.Date;
import java.text.SimpleDateFormat;

/*
* 用于处理学生的添加请求
*
* */

@WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        try {
            //获取客户端提交上来的数据
            String sname = request.getParameter("sname");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            String birthday = request.getParameter("birthday");
            String hobby = request.getParameter("hobby");
            String info = request.getParameter("info");

            //添加到数据库

            Date date = new SimpleDateFormat("yyyy-mm-dd").parse(birthday);
            Student student = new Student(sname,gender,phone,hobby,info,date);
            StudentService service = new StudentServiceImpl();
            service.insert(student);

        }catch (Exception e){
            e.printStackTrace();
        }





        //跳转到列表页

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
