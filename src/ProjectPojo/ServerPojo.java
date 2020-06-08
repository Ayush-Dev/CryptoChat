/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectPojo;

/**
 *
 * @author zz
 */
public class ServerPojo {
    private static String ServerIP;

    public ServerPojo(String ServerIP) {
        ServerPojo.ServerIP = ServerIP;
    }

    public static String getServerIP() {
        return ServerIP;
    }

    public static void setServerIP(String ServerIP) {
        ServerPojo.ServerIP = ServerIP;
    }
    
}