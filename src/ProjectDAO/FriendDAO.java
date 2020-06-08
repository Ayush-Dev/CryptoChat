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
import java.util.ArrayList;

/**
 *
 * @author zz
 */
public class FriendDAO {

    private static final int ONLINE = 1, OFFLINE = 0;

    public static ArrayList<String> pendingFriendRequest(FriendPojo obj) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select uname from " + obj.getUsername() + "_friend where status = ?");
        ps.setInt(1, OFFLINE);
        ResultSet result = ps.executeQuery();
        ArrayList<String> pendingRequest = new ArrayList();
        while (result.next()) {
            pendingRequest.add(result.getString("uname"));
        }
        return pendingRequest;
    }

    public static ArrayList<FriendPojo> showAllFriends(FriendPojo obj) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select uname from " + obj.getUsername() + " where status = ?");
        ps.setInt(1, ONLINE);
        ResultSet result = ps.executeQuery();
        ArrayList<FriendPojo> allFriends = new ArrayList();
        while (result.next()) {
            allFriends.add(new FriendPojo(result.getString("uname")));
        }
        return allFriends;
    }

//    public static ArrayList<FriendPojo> showActiveFriends(UserPojo obj) throws SQLException {
//        Connection conn = DatabaseConnection.getConnection();
//        PreparedStatement ps = conn.prepareStatement("select uname from " + obj.getUsername() + " where status = ?");
//        ps.setInt(1, ONLINE);
//        ResultSet result = ps.executeQuery();
//        ArrayList<FriendPojo> activeFriends = new ArrayList();
//        while (result.next()) {
//            if (UserDAO.getFriendStatus(new FriendPojo(result.getString("uname"))) == ONLINE) {
//                activeFriends.add(new FriendPojo(result.getString("uname")));
//            }
//        }
//        return activeFriends;
//    }

    public static boolean isFriend(UserPojo obj, String username) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select count(*) as total from " + username + "_friend where uname=? and status=?");
        ps.setString(1, obj.getUsername());
        ps.setInt(2, ONLINE);
        ResultSet result = ps.executeQuery();
        return (result.next() && result.getInt(1) == 1);
    }

    public static boolean isFriendRequestSent(UserPojo obj, String username) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps0 = conn.prepareStatement("select count(*) as total from " + username + "_friend where uname=? and status=?");
        ps0.setString(1, obj.getUsername());
        ps0.setInt(2, ONLINE);
        PreparedStatement ps1 = conn.prepareStatement("select count(*) as total from " + obj.getUsername() + "_friend where uname=? and status=?");
        ps1.setString(1, username);
        ps1.setInt(2, OFFLINE);
        ResultSet result0 = ps0.executeQuery();
        ResultSet result1 = ps1.executeQuery();
        return (result0.next() && result0.getInt(1) == 1 && result1.next() && result1.getInt(1) == 1);
    }

    public static void sendFriendRequest(UserPojo obj, String username) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps0 = conn.prepareStatement("insert into " + username + "_friend values(?,?)");
        PreparedStatement ps1 = conn.prepareStatement("insert into " + obj.getUsername() + "_friend values(?,?)");
        ps0.setString(1, obj.getUsername());
        ps0.setInt(2, ONLINE);
        ps1.setString(1, username);
        ps1.setInt(2, OFFLINE);
        ps0.execute();
        ps1.execute();
    }

//    public static boolean unsendFriendRequest(UserPojo obj, String username) throws SQLException {
//        Connection conn = DatabaseConnection.getConnection();
//        PreparedStatement ps = conn.prepareStatement("delete from " + username + "_friend where uname = ? and status = ?");
//        ps.setString(1, obj.getUsername());
//        ps.setInt(2, OFFLINE);
//        int count = ps.executeUpdate();
//        return (count == 1);
//    }
    public static boolean acceptFriendRequest(String obj, String username) throws SQLException, InterruptedException {
        Connection conn = DatabaseConnection.getConnection();
        int count = 0;
        PreparedStatement ps = conn.prepareStatement("update " + username + "_friend set status = ? where uname = ?");
        ps.setInt(1, ONLINE);
        ps.setString(2, obj);
        count += ps.executeUpdate();
        ps = conn.prepareStatement("update " + obj + "_friend set status = ? where uname = ?");
        ps.setInt(1, ONLINE);
        ps.setString(2, username);
        count += ps.executeUpdate();
        return (count == 2);
    }

    public static void deleteFriendRequest(UserPojo obj, String username) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps0 = conn.prepareStatement("delete from " + username + "_friend where uname = ?");
        ps0.setString(1, obj.getUsername());
        PreparedStatement ps1 = conn.prepareStatement("delete from " + obj.getUsername() + "_friend where uname = ?");
        ps1.setString(1, username);
        ps0.execute();
        ps1.execute();
    }

    public static ArrayList<String> onlineFriends() throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        ArrayList<String> acceptedRequest = new ArrayList();
        PreparedStatement ps = conn.prepareStatement("select uname from "+UserPojo.getUserName()+"_friend where status=1");
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            String friend=result.getString("uname");
            PreparedStatement ps1 = conn.prepareStatement("select uname from "+friend + "_friend where status=1 and uname=?");
            ps1.setString(1, UserPojo.getUserName());
            ResultSet result1 = ps1.executeQuery();
            if (result1.next()) {
                PreparedStatement ps2 = conn.prepareStatement("select uname from users where status=1 and uname=?");
                ps2.setString(1, result.getString("uname"));
                ResultSet result2 = ps2.executeQuery();
                if(result2.next()){
                    acceptedRequest.add(result.getString("uname"));
                }
            }
        }
        return acceptedRequest;
    }

    public static boolean rejectFriendRequest(String obj, String username) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        int count = 0;
        PreparedStatement ps = conn.prepareStatement("delete from " + username + "_friend where uname = ?");
        ps.setString(1, obj);
        count += ps.executeUpdate();
        ps = conn.prepareStatement("delete from " + obj + "_friend where uname = ?");
        ps.setString(1, username);
        count += ps.executeUpdate();
        return (count == 2);
    }
    public static ArrayList<String> offlineFriends() throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        ArrayList<String> acceptedRequest = new ArrayList();
        PreparedStatement ps = conn.prepareStatement("select uname from "+UserPojo.getUserName()+"_friend where status=1");
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            String friend=result.getString("uname");
            PreparedStatement ps1 = conn.prepareStatement("select uname from "+friend + "_friend where status=1 and uname=?");
            ps1.setString(1, UserPojo.getUserName());
            ResultSet result1 = ps1.executeQuery();
            if (result1.next()) {
                PreparedStatement ps2 = conn.prepareStatement("select uname from users where status=0 and uname=?");
                ps2.setString(1, result.getString("uname"));
                ResultSet result2 = ps2.executeQuery();
                if(result2.next()){
                    acceptedRequest.add(result.getString("uname"));
                }
            }
        }
        return acceptedRequest;
    }
    public static void getChat(String friend) throws SQLException{
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from "+UserPojo.getUserName()+" where uname=?");
        ps.setString(1, friend);
        
    }
}
