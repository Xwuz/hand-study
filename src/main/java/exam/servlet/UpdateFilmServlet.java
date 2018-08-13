package exam.servlet;

import exam.bean.Film;
import exam.service.FilmService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tiandao
 * @date 2018/8/13 14:52
 */
public class UpdateFilmServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String languageName = request.getParameter("languageName");
        int languageId = Integer.valueOf(languageName);
        String filmId = request.getParameter("filmId");
        new FilmService().updateFilm(Integer.valueOf(filmId),title,description,languageId);
        response.sendRedirect("success.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
