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
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        try {
                //获取客户端提交上来的数据
                int sid = Integer.parseInt(request.getParameter("sid"));
                String sname = request.getParameter("sname");
                String gender = request.getParameter("gender");
                String phone = request.getParameter("phone");
                String birthday = request.getParameter("birthday");

                String info = request.getParameter("info");
                String [] h = request.getParameterValues("hobby");

                String hobby = Arrays.toString(h);
                hobby = hobby.substring(1,hobby.length()-1);

                //添加到数据库

                Date date = new SimpleDateFormat("yyyy-mm-dd").parse(birthday);
                Student student = new Student(sid,sname,gender,phone,hobby,info,date);

                     //更新到数据库
                StudentService service = new StudentServiceImpl();
                service.update(student);


                request.getRequestDispatcher("StudentListServlet").forward(request,response);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
