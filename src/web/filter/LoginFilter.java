package web.filter;

import domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //类型转换
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String requestURI = request.getRequestURI();

        if (requestURI.contains("/login.jsp") || requestURI.contains("/LoginServlet") || requestURI.contains("/js/")
                || requestURI.contains("/css/") || requestURI.contains("/fonts/")) {

            chain.doFilter(req, resp);

        } else {

            HttpSession session = request.getSession();
            String userName = (String)session.getAttribute("name");

            if (userName != null) {

                chain.doFilter(req, resp);

            } else {

                request.setAttribute("login_msg", "您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);

            }
        }
    }


    public void init(FilterConfig config) throws ServletException {

    }

}
