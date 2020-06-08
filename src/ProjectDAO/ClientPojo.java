/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectDAO;

import ProjectPojo.ServerPojo;
import ProjectPojo.UserPojo;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author zz
 */
public class ClientPojo {
    public static void startSocket() throws UnknownHostException, IOException, InterruptedException{
        InetAddress ip; 
            ip = InetAddress.getByName(ServerPojo.getServerIP());
            Socket s = new Socket(ip,1234);
            new DataOutputStream(s.getOutputStream()).writeUTF(UserPojo.getUserName());
    }
}
