package exam.servlet;

import exam.service.FilmService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tiandao
 * @date 2018/8/13 14:34
 */
public class DeleteFilmServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("filmId");
        System.out.println(id);
        new FilmService().deleteFilm(Integer.valueOf(id));
        response.sendRedirect("success.jsp");
    }
}
