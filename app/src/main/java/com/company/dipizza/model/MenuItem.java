package com.company.dipizza.model;

import java.util.Date;
import java.util.Map;

public class MenuItem {

    private int id;
    private String name;
    private String description;
    private String category;
    private Date createdDate;
    private Date updatedDate;
    private Map<String, Double> sizeToPriceMap;

    // Constructor
    public MenuItem(int id, String name, String description, String category, Date createdDate, Date updatedDate, Map<String, Double> sizeToPriceMap) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.sizeToPriceMap = sizeToPriceMap;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Map<String, Double> getSizeToPriceMap() {
        return sizeToPriceMap;
    }

    public void setSizeToPriceMap(Map<String, Double> sizeToPriceMap) {
        this.sizeToPriceMap = sizeToPriceMap;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", sizeToPriceMap=" + sizeToPriceMap +
                '}';
    }
}
