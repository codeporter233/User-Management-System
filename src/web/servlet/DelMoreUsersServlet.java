package web.servlet;

import service.Service;
import service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddUserServlet",urlPatterns = "/DelMoreUsersServlet")
public class DelMoreUsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String[] ids = request.getParameterValues("userId");
        Service service = new ServiceImpl();

        //根据获取的String[] ids 删除user
        if (ids != null && ids.length > 0)
            service.delUsers(ids);

        response.sendRedirect(request.getContextPath()+"/FindUserByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
