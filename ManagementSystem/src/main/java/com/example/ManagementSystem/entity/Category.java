package com.example.ManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryID;


    private String category_name;
    private String category_desc;

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

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_desc() {
        return category_desc;
    }

    public void setCategory_desc(String category_desc) {
        this.category_desc = category_desc;
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
