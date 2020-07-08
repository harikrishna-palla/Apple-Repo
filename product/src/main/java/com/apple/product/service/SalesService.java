package com.apple.product.service;

import com.apple.product.model.Product;
import com.apple.product.model.Sales;
import com.apple.product.repository.ProductRepository;
import com.apple.product.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesService {
    @Autowired
    SalesRepository salesRepository;
    public List<Sales> findSalesList() {
        List<Sales> sales = (List<Sales>) salesRepository.findAll();
        return sales;
    }
    public Sales findSalesById(String salesId){
        Optional<Sales> salesOptional = salesRepository.findById(salesId);
        if(salesOptional.isPresent()) {
            return salesOptional.get();
        }
        else {
            return null;
        }
    }
    public void insertSales(Sales sales) {
        salesRepository.save(sales);
    }
    public void updateSales(Sales sales) {
        salesRepository.save(sales);
    }
    public void deleteSales(Sales sales) {
        salesRepository.delete(sales);
    }
}
