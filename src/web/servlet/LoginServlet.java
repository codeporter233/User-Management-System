package web.servlet;



import service.Service;
import service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("username");
        String password = request.getParameter("password");

        if (name.equals("") || password.equals("")) {
            request.setAttribute("login_msg", "用户名或密码不能为空！");
            //跳转登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            Service service = new ServiceImpl();

            /*
             * 1登录成功
             * 0密码错
             * -1无此用户*/
            int status_code = service.login(name, password);

            if (status_code == 1) {

                HttpSession session = request.getSession();
                session.setAttribute("name", name);
                //跳转列表页面
                response.sendRedirect(request.getContextPath() + "/FindUserByPageServlet");

            } else if (status_code == 0) {

                request.setAttribute("login_msg", "用户名或密码错误!");
                //跳转登录页面
                request.getRequestDispatcher("/login.jsp").forward(request, response);

            } else if (status_code == -1) {

                request.setAttribute("login_msg", "没有该用户!");
                //跳转登录页面
                request.getRequestDispatcher("/login.jsp").forward(request, response);

            }
        }

    }
}



