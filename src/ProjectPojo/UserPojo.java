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
public class UserPojo {
    private String name, username, password, email, publicKey;
    private int status;
    private static String userName,privateKey;

    public static String getPrivateKey() {
        return privateKey;
    }

    public static void setPrivateKey(String privateKey) {
        UserPojo.privateKey = privateKey;
    }

    public UserPojo(String username, String email, String name, String password, String publicKey, int status) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.publicKey = publicKey;
        this.status = status;
    }

    public UserPojo(String name, String email, int status) {
        this.name = name;
        this.email = email;
        this.status = status;
    }

    public UserPojo(String username, int status) {
        this.username = username;
        this.status = status;
    }

    public UserPojo(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public UserPojo(String username) {
        this.username = username;
    }

    public UserPojo() {

    }

    public UserPojo(String username, String password, String privateKey, String publicKey, int status) {
        this.username = username;
        this.publicKey=publicKey;
        this.password = password;
        UserPojo.privateKey = privateKey;
        this.status = status;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        UserPojo.userName = userName;
    }

}
