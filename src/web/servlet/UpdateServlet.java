package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.Service;
import service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "UpdateServlet",urlPatterns = "/UpdateUserServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        Map<String, String[]> userMap = request.getParameterMap();
        User user = new User();


        //BeanUtils工具类，使用Map<String,String[]>封装对象
        try {
            BeanUtils.populate(user,userMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //根据修改后的值重新设置uesr属性
        Service service = new ServiceImpl();
        service.updateUser(user);
        response.sendRedirect(request.getContextPath()+"/FindUserByPageServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
