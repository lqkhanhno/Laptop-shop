/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class FAQs {
    int ID;
    User authorID;
    String title;
    String content;

    public FAQs() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public User getAuthorID() {
        return authorID;
    }

    public void setAuthorID(User authorID) {
        this.authorID = authorID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public FAQs(int ID, User authorID, String title, String content) {
        this.ID = ID;
        this.authorID = authorID;
        this.title = title;
        this.content = content;
    }

    
}
