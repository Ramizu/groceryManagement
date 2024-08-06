package com.example.ManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryID;


    private String categoryName;
    private String categoryDesc;

    @Column
    @Temporal(TemporalType.DATE)
    private Date crt_dt_ts;

    public Category() {}

    public Long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
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
