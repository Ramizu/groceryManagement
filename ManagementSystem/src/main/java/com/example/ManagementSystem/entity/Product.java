package com.example.ManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.lang.NonNull;

import java.util.Date;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long prod_ID;

    @Column
    @NonNull
    private String prod_name;

    @Column
    @NonNull
    private double prod_price;

    @Column
    @NonNull
    private int availability;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable=false, updatable=false)
    private Category category ;
    private Long category_ID;

    @Temporal(TemporalType.DATE)
    @NonNull
    private Date created_date;

    public Product() {}

    public Long getProd_ID() {
        return prod_ID;
    }

    public void setProd_ID(Long prod_ID) {
        this.prod_ID = prod_ID;
    }

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

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    @PrePersist
    protected void onCreate() {
        created_date = new Date();
    }
}