package com.example.ManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long prod_ID;

    @Column
    private String prod_name;

    @Column
    private double prod_price;

    @Column
    private boolean availability;

    @Column
    private Long category_ID;

    @Temporal(TemporalType.DATE)
    private Date crt_dt_ts;

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

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Long getCategory_ID() {
        return category_ID;
    }

    public void setCategory_ID(Long category_ID) {
        this.category_ID = category_ID;
    }

    public Date getCrt_dt_ts() {
        return crt_dt_ts;
    }

    public void setCrt_dt_ts(Date crt_dt_ts) {
        this.crt_dt_ts = crt_dt_ts;
    }

    @PrePersist
    protected void onCreate() {
        crt_dt_ts = new Date();
    }
}
