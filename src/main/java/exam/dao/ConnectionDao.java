package exam.dao;

import exam.bean.Film;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author tiandao
 * @date 2018/8/13 10:49
 */
public class ConnectionDao {

    private static Connection connection;

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/sakila?useUnicode=true&amp;characterEncoding=utf-8";
    private static final String USER="root";
    private static final String PASSWORD="root";

    public static Connection getConnection(){
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得数据库链接
            connection=DriverManager.getConnection(URL, USER, PASSWORD);
            //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
