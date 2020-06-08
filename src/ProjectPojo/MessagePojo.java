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
public class MessagePojo {
    private String username;
    private  String message;
//    ArrayList<String> message=new ArrayList();
//    private int count;

    public MessagePojo(String username, String message) {
        this.username = username;
        this.message = message;
//        this.message.add(message);
//        this.count=0;
    }

//    public MessagePojo() {
//        this.count=1;
//    }
//
//    public MessagePojo(String username) {
//        this.username=username;
//        this.count=1;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public String getMessage(int i) {
//        return this.message.get(i);
//    }
//
//    public void setMessage(String message) {
//        this.message.add(message);
//        this.count+=1;
//    }

//    public int getCount() {
//        return count;
//    }
//
//    public void setCount(int count) {
//        this.count = count;
//    }
    
}
