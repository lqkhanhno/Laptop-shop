/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Comment {
    private int userID;
    private int produtID;
    private String comment;

    public Comment() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public Comment(int userID, int produtID, String comment) {
        this.userID = userID;
        this.produtID = produtID;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" + "userID=" + userID + ", produtID=" + produtID + ", comment=" + comment + '}';
    }

    
}
