package com.example.ManagementSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.lang.NonNull;

public class ProductDTO {

    private String prod_name;
    private double prod_price;
    private int availability;

    private Category category ;
    private Long category_ID;

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public double getProd_price() {
        return prod_price;
    }

    public void setProd_price(double prod_price) {
        this.prod_price = prod_price;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public Long getCategory_ID() {
        return category_ID;
    }

    public void setCategory_ID(Long category_ID) {
        this.category_ID = category_ID;
    }
}