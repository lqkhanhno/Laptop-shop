/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Comment {
    int cmtID;
    int productID;
    int comment;

    public Comment() {
    }

    public Comment(int cmtID, int productID, int comment) {
        this.cmtID = cmtID;
        this.productID = productID;
        this.comment = comment;
    }

    public int getCmtID() {
        return cmtID;
    }

    public void setCmtID(int cmtID) {
        this.cmtID = cmtID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }
    
}
