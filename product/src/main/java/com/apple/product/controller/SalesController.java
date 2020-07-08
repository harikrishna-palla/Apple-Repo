package com.apple.product.controller;

import com.apple.product.model.Product;
import com.apple.product.model.ProductCategory;
import com.apple.product.model.Sales;
import com.apple.product.service.ProductService;
import com.apple.product.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalesController {
    @Autowired
    SalesService salesService;
    @Autowired
    ProductService productService;
    @GetMapping("/sales")
    public List<Sales> getAllSalesList() {
        return salesService.findSalesList();
    }
    @GetMapping("/sales/{salesId}")
    public Sales getSalesById(@PathVariable String saleId) {
        return salesService.findSalesById(saleId);
    }
    @PostMapping("/product/{productID}/sales")
    public void addSales(@RequestBody Sales sales, @PathVariable int productID) {
        Product product = productService.findProductById(productID);
        sales.setProduct(product);
        salesService.insertSales(sales);
    }
    @PutMapping("/product/{productID}/sales")
    public void updateSales(@RequestBody Sales sales, @PathVariable int productID) {
        Product product = productService.findProductById(productID);
        sales.setProduct(product);
        salesService.updateSales(sales);
    }
    @DeleteMapping("/sales/{saleId}")
    public void deleteSales(@PathVariable Sales sales) {
        salesService.deleteSales(sales);
    }
}
