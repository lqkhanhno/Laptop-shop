/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;
import java.sql.Timestamp;

public class Order {
    int ID;
    int userID;
    int totalPrice;
    String status;
    Date orderDate;
    String note;
    Timestamp updated_At;

    public Order() {
    }

    public Order(int ID, int userID, int totalPrice, String status, Date orderDate, String note, Timestamp updated_At) {
        this.ID = ID;
        this.userID = userID;
        this.totalPrice = totalPrice;
        this.status = status;
        this.orderDate = orderDate;
        this.note = note;
        this.updated_At = updated_At;
    }

    public Order(int userID, int totalPrice, String status, Date orderDate, String note) {
        this.userID = userID;
        this.totalPrice = totalPrice;
        this.status = status;
        this.orderDate = orderDate;
        this.note = note;
    }

    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Timestamp getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At() {
        this.updated_At = new Timestamp(System.currentTimeMillis());
        System.out.println(this.updated_At);
    }
    
    public Timestamp getTimeNow(){
        return new Timestamp(System.currentTimeMillis());
    }
   
    
    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        Order o = new Order();
        o.setUpdated_At();
        System.out.println(o.getUpdated_At());
    }
}