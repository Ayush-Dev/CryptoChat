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
public class FriendPojo {
    private String username, friendName;
    private int status;

    public FriendPojo(String username, String friendName, int status) {
        this.username = username;
        this.friendName = friendName;
        this.status = status;
    }

    public FriendPojo(String username, int status) {
        this.username = username;
        this.status = status;
    }

    public FriendPojo(String username){
        this.username = username;
    }

    public FriendPojo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }
}
