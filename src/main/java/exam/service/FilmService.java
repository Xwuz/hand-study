package exam.service;

import exam.bean.Film;
import exam.bean.Language;
import exam.dao.CustomerDao;
import exam.dao.LanguageDao;

import java.util.List;

/**
 * @author tiandao
 * @date 2018/8/13 13:14
 */
public class FilmService {

    public void addFilm(Film film){
        new CustomerDao().addFilm(film);
    }

    public List<Film> getFilmAll(){
        return new CustomerDao().getFilm();
    }

    public Film getFilmById(int filmId){
        Film film = null;
        List<Film> list = new CustomerDao().getFilm();
        for (Film film1 : list){
            if (film1.getFilmId() == filmId){
                film = film1;
            }
        }
        return film;
    }

    public void deleteFilm(int filmId){
        new CustomerDao().deleteFilm(filmId);
    }

    public List<Language> getLanguage(){
        return new LanguageDao().getLanguage();
    }

    public void updateFilm(int filmId,String title,String description,int languageId){
        Film film = new Film(filmId,title,description,languageId);
        System.out.println(film);
        new CustomerDao().updateFilm(film);
    }
}
