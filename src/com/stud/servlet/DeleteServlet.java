package com.stud.servlet;

import com.stud.service.StudentService;
import com.stud.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/*用于处理删除学生
 */
@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            //接受id
            int sid = Integer.parseInt(request.getParameter("sid"));

            //执行删除
            StudentService service = new StudentServiceImpl();
            service.delete(sid);

            //跳转到列表页
            request.getRequestDispatcher("StudentListServlet").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
