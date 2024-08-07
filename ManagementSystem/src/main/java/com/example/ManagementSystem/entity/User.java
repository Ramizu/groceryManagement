package com.example.ManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private String user_name;
    private String user_pswd;
    private String is_admin;
    private String email;
    private String phone_num;

    @Temporal(TemporalType.DATE)
    private Date crt_dt_ts;

    @PrePersist
    protected void onCreate() {
        crt_dt_ts = new Date();
    }

}
