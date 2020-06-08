
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author zz
 */
public class DatabaseConnection {
    private static Connection conn;
    private static  String ip="192.168.43.56";
    static{
        try{//            ServerPojo serverPojo = new ServerPojo(ip);
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://"+ip+":3306/chat","chat","chat");
        } 
        catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection(){
        return conn;
    }
    
    public static void closeConnection() {
        try{
            conn.close();
            JOptionPane.showMessageDialog(null, "Connection closed Successfully !!");
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cannot connect to Database !!");
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
