package com.example.ManagementSystem.service;

import com.example.ManagementSystem.entity.Sales;

import java.util.List;

public interface SalesService {

    String addSales(Sales sales);
    List<Sales> getAllSales();
    Sales getSaleById(Long salesid);
//    void deleteSale(Long id);
}
