/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

public class Product {
    int productID;
    String productName,image;
    String description;
    int originalPrice;
    int categoryID;
    int sellPrice;
    int salePercent;
    int amount;
    int suppliID;
    Date releaseDate;
    int isSell;
    
    

    public Product() {
    }

    public Product(int productID, String productName, String image, String description, int originalPrice, int categoryID, int sellPrice, int salePercent, int amount, int suppliID, Date releaseDate, int isSell) {
        this.productID = productID;
        this.productName = productName;
        this.image = image;
        this.description = description;
        this.originalPrice = originalPrice;
        this.categoryID = categoryID;
        this.sellPrice = sellPrice;
        this.salePercent = salePercent;
        this.amount = amount;
        this.suppliID = suppliID;
        this.releaseDate = releaseDate;
        this.isSell = isSell;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getIsSell() {
        return isSell;
    }

    public void setIsSell(int isSell) {
        this.isSell = isSell;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", image=" + image + ", description=" + description + ", originalPrice=" + originalPrice + ", categoryID=" + categoryID + ", sellPrice=" + sellPrice + ", salePercent=" + salePercent + ", amount=" + amount + ", suppliID=" + suppliID + ", releaseDate=" + releaseDate + ", isSell=" + isSell + '}';
    }

    
    
}
