package exam.dao;

import exam.bean.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tiandao
 * @date 2018/8/13 10:46
 */
public class CustomerDao {

    private Connection connection;

    public CustomerDao() {
        this.connection = ConnectionDao.getConnection();
    }

    PreparedStatement pst = null;

    public int CustomerLogin(String firstName) {
        connection = ConnectionDao.getConnection();
        int count = 0;
        String sql = "select first_name from customer where first_name = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, firstName);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
//                    System.out.println(rs.getString("first_name") + "++++");
                    count++;
                }
            }
            pst.close();
            rs.close();
            ;
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<Film> getFilm() {
        connection = ConnectionDao.getConnection();
        List<Film> films = new ArrayList<>();
        String sql = "select f.film_id,f.title,f.description,l.name,f.language_id from film f,language l where f.language_id=l.language_id order by f.film_id desc";
        Film film = null;
        try {
            pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                film = new Film();
                film.setFilmId(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                film.setLanguageName(rs.getString("name"));
//                System.out.println(film);
                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return films;
    }

    public void addFilm(Film film) {
        connection = ConnectionDao.getConnection();
        String sql = "insert film(title,description,language_id) values(?,?,?)";
        System.out.println(film.getTitle() + "==========");
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, film.getTitle());
            pst.setString(2, film.getDescription());
            pst.setInt(3, film.getLanguageId());
            pst.executeUpdate();
//            System.out.println(pst.executeUpdate() + "+++++++++++");
            pst.close();
            ;
            connection.close();
        } catch (SQLException e) {
            System.out.println("添加失败");
            e.printStackTrace();
        }
    }


    public void deleteFilm(int filmId){
        connection = ConnectionDao.getConnection();
        String sql = "delete from film where film_id = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,filmId);
            pst.executeUpdate();
            pst.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFilm(Film film){
        connection = ConnectionDao.getConnection();
        String sql = "update film set title = ?,description = ?,language_id = ? where film_id = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,film.getTitle());
            pst.setString(2,film.getDescription());
            pst.setInt(3,film.getLanguageId());
            pst.setInt(4,film.getFilmId());
            pst.executeUpdate();
            pst.close();;
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Film getFilmById(int filmId){
        Film film = new Film();
        connection = ConnectionDao.getConnection();
        String sql = "select f.film_id,f.title,f.description,l.name from film f,language l where f.language_id=l.language_id and f.film_id=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,filmId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }


    public static void main(String[] args) {
//        new CustomerDao().CustomerLogin("MA213RY");
        Film film = new Film();
        film.setTitle("fwefwe");
        film.setDescription("dasff");
        film.setLanguageId(2);
        new CustomerDao().addFilm(film);
    }
}
