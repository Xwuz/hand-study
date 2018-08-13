package exam.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)arg0;
        HttpServletResponse response = (HttpServletResponse)arg1;
        HttpSession session = request.getSession();
        String path = request.getRequestURI();
        String firstName = (String)session.getAttribute("firstName");
        if(path.indexOf("/login.jsp") > -1 || path.indexOf("/index.jsp") > -1) {//注意：登录页面千万不能过滤  不然过滤器就。。。。。自行调试不要偷懒！这样记忆深刻
            arg2.doFilter(request, response);
            return;
        } else {//如果不是login.jsp进行过滤
            if (firstName == null || "".equals(firstName)) {
                // 跳转到登陆页面
                response.sendRedirect("login.jsp");
            } else {
                // 已经登陆,继续此次请求
                arg2.doFilter(request, response);
            }
        }


    }

    @Override
    public void destroy() {

    }
}
