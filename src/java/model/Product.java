/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Product {
    int productID;
    String productName;
    String description;
    int originalPrice;
    int categoryID;
    int sellPrice;
    int salePercent;
    int amount;
    int suppliID;

    public Product() {
    }

    public Product(int productID, String productName, String description, int originalPrice, int categoryID, int sellPrice, int salePercent, int amount, int suppliID) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.originalPrice = originalPrice;
        this.categoryID = categoryID;
        this.sellPrice = sellPrice;
        this.salePercent = salePercent;
        this.amount = amount;
        this.suppliID = suppliID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getSalePercent() {
        return salePercent;
    }

    public void setSalePercent(int salePercent) {
        this.salePercent = salePercent;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSuppliID() {
        return suppliID;
    }

    public void setSuppliID(int suppliID) {
        this.suppliID = suppliID;
    }
    
}
