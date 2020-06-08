/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectPojo;

import java.util.ArrayList;

/**
 *
 * @author zz
 */
public class testMessagePojo {
    String username;
    ArrayList<String> message;
    ArrayList<Integer> flag;

    public int getFlag(int i) {
        return flag.get(i);
    }

    public void setFlag(int flag) {
        this.flag.add(flag);
    }

    public testMessagePojo(String username) {
        this.username = username;
        this.message=new ArrayList();
        this.flag=new ArrayList();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage(int i) {
        return message.get(i);
    }

    public void setMessage(String message) {
        this.message.add(message);
    }
    public int getSize() {
        return message.size();
    }
}
