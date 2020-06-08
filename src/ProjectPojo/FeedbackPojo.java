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
public class FeedbackPojo {
    private String username, feedback, item, cateogry;

    public FeedbackPojo(String username, String feedback, String item, String cateogry) {
        this.username = username;
        this.feedback = feedback;
        this.item = item;
        this.cateogry = cateogry;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCateogry() {
        return cateogry;
    }

    public void setCateogry(String cateogry) {
        this.cateogry = cateogry;
    }
}
