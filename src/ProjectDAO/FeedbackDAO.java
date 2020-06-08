/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectDAO;

import ProjectDatabase.DatabaseConnection;
import ProjectPojo.FeedbackPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author zz
 */
public class FeedbackDAO {
    public static void sendFeedback(FeedbackPojo obj) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into feedback values(?,?,?,?)");
        ps.setString(1, obj.getUsername());
        ps.setString(2, obj.getFeedback());
        ps.setString(3, obj.getItem());
        ps.setString(4, obj.getCateogry());
        ps.execute();
    }
}
