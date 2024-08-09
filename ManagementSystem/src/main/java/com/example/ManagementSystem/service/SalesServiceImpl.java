package com.example.ManagementSystem.service;

import com.example.ManagementSystem.entity.Sales;
import com.example.ManagementSystem.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService{

    @Autowired
    private SalesRepository salesRepository;

    @Override
    public String addSales(Sales sales){
         salesRepository.save(sales);
         return "Success";
    }

    @Override
    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    @Override
    public Sales getSaleById(Long salesid) {
        return salesRepository.findById(salesid).orElse(null);
    }


}
