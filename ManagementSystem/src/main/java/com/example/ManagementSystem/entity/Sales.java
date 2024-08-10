package com.example.ManagementSystem.entity;


import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
public class Sales {

    // Primary key

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private int salesid;
    private Long prodId; // Product ID from Product table
    private String prodName; // Product Name
    private int availability; // Availability from Product table
    private double prodPrice; // Product Price

    // Default constructor
    public Sales() {
    }

    // Parameterized constructor
    public Sales(Long prodId, String prodName, int availability, double prodPrice) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.availability = availability;
        this.prodPrice = prodPrice;
    }

    // Getters and Setters

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }
}