/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectDAO;

import ProjectDatabase.DatabaseConnection;
import ProjectPojo.MessagePojo;
import ProjectPojo.UserPojo;
import ProjectPojo.testMessagePojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author zz
 */
public class MessageDAO {

    private static final int SEND = 0, RECIEVE = 1;

    public static boolean addUserMessageTable(UserPojo obj) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        Statement st = conn.createStatement();
        int count = st.executeUpdate("create table " + obj.getUsername() + "(uname varchar(101) not null, message varchar(1500), time datetime not null default now(),flag int(1))");
        return (count == 0);
    }

    public static boolean addUserFriendTable(UserPojo obj) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        Statement st = conn.createStatement();
        int count = st.executeUpdate("create table " + obj.getUsername() + "_friend(uname varchar(101) primary key, status int(1) not null default 0)");
        return (count == 0);
    }

    public static void sendMessage(MessagePojo obj) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps1 = conn.prepareStatement("insert into "+ UserPojo.getUserName() +"(uname,message,flag) values(?,?,?)");
        ps1.setString(1, obj.getUsername());
        ps1.setString(2, obj.getMessage());
        ps1.setInt(3, SEND);
        PreparedStatement ps2 = conn.prepareStatement("insert into "+obj.getUsername()+"(uname,message,flag) values(?,?,?)");
        ps2.setString(1, UserPojo.getUserName());
        ps2.setString(2, obj.getMessage());
        ps2.setInt(3, RECIEVE);
        ps1.executeUpdate();
        ps2.executeUpdate();
    }

//    public static void sendMessage(MessagePojo obj) throws SQLException {
//        Connection conn = DatabaseConnection.getConnection();
//        PreparedStatement ps = conn.prepareStatement("insert into "+UserPojo.getUserName()+"(uname,message,flag) values(?,?,?)");
////        ps.setObject(1, UserPojo.getUserName());
//        ps.setString(1, obj.getUsername());
//        ps.setString(2, obj.getMessage(obj.getCount()));
//        ps.setInt(3, 1);
//        ps.executeUpdate();
//        ps = conn.prepareStatement("insert into "+UserPojo.getUserName()+"(uname,message,flag) values(?,?,?)");
////        ps.setObject(2, UserPojo.getUserName());
//        ps.setString(1, obj.getUsername());
//        ps.setString(2, obj.getMessage(obj.getCount()));
//        ps.setInt(3, 0);
//        ps.executeUpdate();
//        System.out.println("done");
//    }

    

    public static testMessagePojo getAllMessage(String obj) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
//        PreparedStatement ps = conn.prepareStatement("select message from "+UserPojo.getUserName()+" where uname=?");
        PreparedStatement ps = conn.prepareStatement("select message,flag from "+UserPojo.getUserName()+" where uname=?");
        ps.setString(1, obj);
        ResultSet rs = ps.executeQuery();
        testMessagePojo msg=new testMessagePojo(obj);
        while(rs.next()){
            msg.setMessage(rs.getString(1));
            msg.setFlag(rs.getInt(2));
        }
        return msg;
    }
    public static ResultSet getTable(String user) throws SQLException{
        Connection conn = DatabaseConnection.getConnection();
//        PreparedStatement ps = conn.prepareStatement("select message,flag from "+UserPojo.getUserName()+" where uname=?");
        PreparedStatement ps = conn.prepareStatement("select message,flag from a where uname='b'");
//        ps.setString(1, user);
        ResultSet result = ps.executeQuery();
        return result;
    }
}
