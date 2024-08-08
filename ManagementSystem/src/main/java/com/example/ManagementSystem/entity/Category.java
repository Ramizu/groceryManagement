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
    private Integer categoryid;
    private String category_name;
    private String category_desc;

    @Column
    @Temporal(TemporalType.DATE)
    private Date crt_dt_ts;

    @PrePersist
    protected void onCreate() {
        crt_dt_ts = new Date();
    }


}
