/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class Supplier {
    int ID;
    String name;
    String phone;
    String address;

    public Supplier() {
    }

    public Supplier(int ID, String name, String phone, String address) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Supplier{" + "ID=" + ID + ", name=" + name + ", phone=" + phone + ", address=" + address + '}';
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
