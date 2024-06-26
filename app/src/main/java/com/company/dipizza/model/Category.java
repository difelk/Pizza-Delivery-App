package com.company.dipizza.model;

import java.util.Date;

public class Category {

    private int id;
    private String categoryName;

    private int categoryIcon;

    private String categoryType;

    private String price;

    public Category(int id, String name, int icon, String price) {
        this.id = id;
        this.categoryName = name;
        this.categoryIcon = icon;
        this.price = price;
    }

    public int getCategoryIcon() {
        return categoryIcon;
    }


    public void setCategoryIcon(int categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getPrice() {
        return price;
    }
    private Date createdDate;

    private Date updatedDate;
}
