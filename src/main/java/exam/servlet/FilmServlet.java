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
 * @date 2018/8/13 12:59
 */
public class FilmServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String languageName = request.getParameter("languageName");
        int languageId = Integer.valueOf(languageName);
//        System.out.println(title+"\n"+description+"\n"+languageId);
        Film film = new Film();
        film.setTitle(title);
        film.setDescription(description);
        film.setLanguageId(languageId);
        new FilmService().addFilm(film);
        response.sendRedirect("success.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
