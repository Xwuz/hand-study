package exam.dao;

import exam.bean.Language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tiandao
 * @date 2018/8/13 14:10
 */
public class LanguageDao {

    private Connection connection;
    PreparedStatement pst = null;

    public LanguageDao(){
        this.connection = ConnectionDao.getConnection();
    }

    public List<Language> getLanguage(){
        List<Language> list = new ArrayList<>();
        String sql = "select language_id,name from language";
        try {
            pst = connection.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                Language language = new Language();
                language.setLanguageId(resultSet.getInt("language_id"));
                language.setName(resultSet.getString("name"));
                list.add(language);
            }
            resultSet.close();
            pst.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
