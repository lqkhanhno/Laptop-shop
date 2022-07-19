/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class Comment {
    private User user;
    private int produtID;
    private String comment;
    private String date;

    public Comment() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getProdutID() {
        return produtID;
    }

    public void setProdutID(int produtID) {
        this.produtID = produtID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Comment(User user, int produtID, String comment, String date) {
        this.user = user;
        this.produtID = produtID;
        this.comment = comment;
        this.date = date;
    }

    
    
}
