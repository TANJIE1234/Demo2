package dao;

import entity.User;
import utils.DBHelper;

import java.sql.*;

public class UserDao {
    public String findUsername(String username){
        String psw = null;
        Connection con =null;
        PreparedStatement pstmt =null;
        ResultSet rs = null;
        try {
            con = DBHelper.getConnection();
            String sql = "select * from users where username=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            if(rs==null){
                return null;
            }
            if(rs.next()){
                psw=rs.getString("password");
            }else{
                psw=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt!=null)
                    pstmt.close();
                if(rs!=null)
                    rs.close();
            }
            catch (SQLException e) {
            }
        }
        return psw;
    }
    public void addUser(User user){
        Connection con =null;
        PreparedStatement pstmt =null;
        try {
            con = DBHelper.getConnection();
            String sql = "INSERT INTO users(`username`,`password`,`phone`,`email`)  VALUES(?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3,user.getPhone());
            pstmt.setString(4,user.getEmail());
            pstmt.executeUpdate();
        }  catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt!=null)pstmt.close();
            }
            catch (SQLException e) {
            }
        }
    }
    //单独测试使用
//    public static void main(String[] args) {
//        User user = new User("gkja","ashgkjsa","oiet","gjlkag");
//        String psw =new UserDao().findUsername(user.getUsername());
//        System.out.println(psw);
//        UserDao u = new UserDao();
//        u.addUser(user);
//        String psw1 =new UserDao().findUsername(user.getUsername());
//        System.out.println(psw1);
//    }

}

