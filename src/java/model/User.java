/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class User {
    int userID;
    String fullname;
    String username;
    String password;
    String email;
    int roleID;
    String userAddress;
    String phoneNumber;

    public User() {
    }

    public User(int userID, String fullname, String username, String password, String email, int roleID, String userAddress, String phoneNumber) {
        this.userID = userID;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roleID = roleID;
        this.userAddress = userAddress;
        this.phoneNumber = phoneNumber;
    }
    
    public User(String fullname, String username, String password, String email, int roleID, String userAddress, String phoneNumber) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roleID = roleID;
        this.userAddress = userAddress;
        this.phoneNumber = phoneNumber;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", username=" + username + ", password=" + password + ", email=" + email + ", roleID=" + roleID + ", userAddress=" + userAddress + ", phoneNumber=" + phoneNumber + '}';
    }
    
    
}
