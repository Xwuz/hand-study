package exam.servlet;

import exam.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author tiandao
 * @date 2018/8/13 11:36
 */
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        System.out.println(firstName);
        int count = new CustomerDao().CustomerLogin(firstName);
        System.out.println(count);
        if (count == 1){
            HttpSession session = request.getSession();
            session.setAttribute("firstName",firstName);
            PrintWriter out = response.getWriter();
//            out.flush();
            out.print("<script type='text/javascript'>alert('登陆成功');</script>");
            response.sendRedirect("success.jsp");
        }else {
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("firstName",null);
        response.sendRedirect("login.jsp");
    }
}
