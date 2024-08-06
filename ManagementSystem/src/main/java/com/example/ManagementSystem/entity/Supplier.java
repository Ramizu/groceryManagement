package com.example.ManagementSystem.entity;


import jakarta.persistence.*;

import lombok.Data;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long suppID;

    private String suppName;
    private String suppPhone;
    private String suppAddress;
    private String suppEmail;

    public Long getSuppID() {
        return suppID;
    }

    public void setSuppID(Long suppID) {
        this.suppID = suppID;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getSuppPhone() {
        return suppPhone;
    }

    public void setSuppPhone(String suppPhone) {
        this.suppPhone = suppPhone;
    }

    public String getSuppAddress() {
        return suppAddress;
    }

    public void setSuppAddress(String suppAddress) {
        this.suppAddress = suppAddress;
    }

    public String getSuppEmail() {
        return suppEmail;
    }

    public void setSuppEmail(String suppEmail) {
        this.suppEmail = suppEmail;
    }
}
