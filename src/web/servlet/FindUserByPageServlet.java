package web.servlet;

import domain.PageBean;
import domain.User;
import service.Service;
import service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "FindUserByPageServlet",urlPatterns = "/FindUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");


        //当前页码
        String currentPage = request.getParameter("currentPage");
        //每页条数
        String rows = request.getParameter("rows");

        if(currentPage == null || "".equals(currentPage)){

            currentPage = "1";
        }


        if(rows == null || "".equals(rows)){
            rows = "5";
        }

        //POST/GET传递的参数值Map集合
        Map<String, String[]> condition = request.getParameterMap();
        for (String key: condition.keySet()
             ) {
            System.out.println(key + ":" + condition.get(key)[0]);
        }
        Service service = new ServiceImpl();
        //根据currentPage，rows，condition查询数据库
        PageBean pb = service.findUserByPage(currentPage,rows,condition);


        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);

        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
