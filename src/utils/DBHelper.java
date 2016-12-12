package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by zyzz5 on 2016/12/12.
 */
public class DBHelper {
    public static final String Driver = "com.mysql.jdbc.Driver";
    public static final String URL ="jdbc:mysql://114.212.238.86:3306/nanwugui?useUnicode=true&characterEncoding=utf-8";
    public static final String USER ="root";
    public static final String PASSWORD ="521678";
    static Connection conn = null;
    static {
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (conn ==null){
            conn =DriverManager.getConnection(URL,USER,PASSWORD);
            return conn;
        }
        else {
            return conn;
        }
    }

    public static void main(String args[]) throws SQLException {
        DBHelper.getConnection();
    }
}

