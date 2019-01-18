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
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;

/*
* 用于处理学生的添加请求
*
* */

@WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf8");

        try {
            //获取客户端提交上来的数据
            String sname = request.getParameter("sname");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            String birthday = request.getParameter("birthday");
            //String hobby = request.getParameter("hobby");
            String info = request.getParameter("info");
            String [] h = request.getParameterValues("hobby");

            String hobby = Arrays.toString(h);
            hobby = hobby.substring(1,hobby.length()-1);

            //添加到数据库

            Date date = new SimpleDateFormat("yyyy-mm-dd").parse(birthday);
            Student student = new Student(sname,gender,phone,hobby,info,date);
            StudentService service = new StudentServiceImpl();
            service.insert(student);

        }catch (Exception e){
            e.printStackTrace();
        }

        //跳转到列表页
        //再查一次数据库,然后在装到作用域中，然后再跳转
        //这里是直接跳转到页面上，那么这个页面再重新翻译一次，上面的那个request的请求存放的数据是没有了
        //request.getRequestDispatcher("list.jsp").forward(request,response);

        //servlet除了能跳转jsp之外，还能跳转servlet
        request.getRequestDispatcher("StudentListServlet").forward(request,response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
