package web.servlet;

import domain.User;
import service.Service;
import service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FindUserServlet",urlPatterns = "/FindUserServlet")
public class FindUserServlet extends HttpServlet {

    //在update.jsp上回显选择要修改的对象属性
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        Service service = new ServiceImpl();
        User user = service.findUserById(id);


        request.setAttribute("user",user);
        request.getRequestDispatcher("/update.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
