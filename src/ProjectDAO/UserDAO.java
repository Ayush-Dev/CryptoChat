/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectDAO;

import ProjectDatabase.DatabaseConnection;
import ProjectPojo.FriendPojo;
import ProjectPojo.UserPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author zz
 */
public class UserDAO {
    public static boolean isUsernameAvailable(UserPojo obj) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select count(*) as total from users where uname=?");
        ps.setString(1, obj.getUsername());
        ResultSet result= ps.executeQuery();
        return (result.next() && result.getInt(1)==1) ;
    }
    public static boolean isEmailAvailable(UserPojo obj) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select count(*) as total from users where email=?");
        ps.setString(1, obj.getEmail());
        ResultSet result= ps.executeQuery();
        return (result.next() && result.getInt(1)==1) ;
    }

    public static boolean addNewUser(UserPojo obj) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into users values(?,?,?,?,?,?)");
        ps.setString(1, obj.getUsername());
        ps.setString(2, obj.getEmail());
        ps.setString(3, obj.getname());
        ps.setString(4, obj.getPassword());
        ps.setString(5, obj.getPublicKey());
        ps.setInt(6, obj.getStatus());
        int count = ps.executeUpdate();
        return (count==1);
    }

    public static boolean isUserValid(UserPojo obj) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select count(*) as total from users where uname=? and password=? and publick=?");
        ps.setString(1, obj.getUsername());
        ps.setString(2, obj.getPassword());
        ps.setString(3, obj.getPublicKey());
        ResultSet result = ps.executeQuery();
        return (result.next() && result.getInt(1)==1);
    }

    public static String getUserPassword(UserPojo obj) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select password from users where uname=?");
        ps.setString(1, obj.getUsername());
        ResultSet result = ps.executeQuery();
        if(result.next()){
            return result.getString("password");
        }
        return "EMPTY_PASSWORD";
    }

    public static void updateUserStatus(UserPojo obj) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update users set status=? where uname=?");
        ps.setInt(1, obj.getStatus());
        ps.setString(2, obj.getUsername());
        ps.executeUpdate();
    }

    public static int getUserStatus(UserPojo obj) throws SQLException {           //gives user Online or Offline status from users Table
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select status from users where uname=?");
        ps.setString(1, obj.getUsername());
        ResultSet result = ps.executeQuery();
        result.next();
        return result.getInt(1);
    }

    public static UserPojo getUsernameAndEmail(UserPojo obj) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from users where uname=?");
        ps.setString(1, obj.getUsername());
        ResultSet result = ps.executeQuery();
        if(result.next()){
            UserPojo user = new UserPojo(result.getString("name"), result.getString("email"), result.getInt("status"));
            return user;
        }
        UserPojo user = new UserPojo(null,null);
        return user;
    }

    public static int getFriendStatus(FriendPojo obj) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select status from users where uname=?");
        ps.setString(1, obj.getUsername());
        ResultSet result = ps.executeQuery();
        result.next();
        return result.getInt(1);
    }

    public static String getFriendKey(FriendPojo obj) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select publick from users where uname=?");
        ps.setString(1, obj.getUsername());
        ResultSet result = ps.executeQuery();
        result.next();
        return result.getString(1);
    }

    public static boolean updateUserPassword(UserPojo obj) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update users set password=? where uname=?");
        ps.setString(1, obj.getPassword());                                       
        ps.setString(2, UserPojo.getUserName());
        int count = ps.executeUpdate();
        return (count == 1);
    }

    public static String getPublicKey(UserPojo obj) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select publick from users where uname=?");
        ps.setString(1, obj.getUsername());
        ResultSet result = ps.executeQuery();
        result.next();
        return result.getString("publick");
    }
}
