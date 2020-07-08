package com.apple.product.controller;

import com.apple.product.model.ProductCategory;
import com.apple.product.service.ProductCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductCategoryController {
    Logger logger = LoggerFactory.getLogger(ProductCategoryController.class);
    @Autowired
    ProductCategoryService productCategoryService;
    @GetMapping("/health")
    public String getHelthCondition() {
        logger.info("health check : Application up and running");
        logger.trace("Trace app : Application up and running");
        return "Application up and running";
    }
    @GetMapping("/prodCategory")

    public List<ProductCategory> getAllprodCategoryList() {
    return productCategoryService.findProductCategoryList();
    }
    @GetMapping("/prodCategory/{prodCategoryID}")
    public ProductCategory getProdCategoryById(@PathVariable Integer prodCategoryID) {
        return productCategoryService.findProdCategoryById(prodCategoryID);
    }
    @PostMapping("/prodCategory")
    public void addProdCategories(@RequestBody ProductCategory productCategory) {
    productCategoryService.insertProductCategories(productCategory);
    logger.trace("productCategory : "+String.valueOf(productCategory.toString()));
    }
    @PutMapping("/prodCategory")
    public void updateProdCategories(@RequestBody ProductCategory productCategory) {
        productCategoryService.updateProductCategories(productCategory);
    }
    @DeleteMapping("/prodCategory")
    public void deleteProdCategories(@RequestBody ProductCategory productCategory) {
        productCategoryService.deleteProductCategories(productCategory);
    }
    @DeleteMapping("/prodCategory/{categoryId}")
    public void deleteProdCategoryById(@PathVariable int categoryId) {
        productCategoryService.deleteProductCategoryById(categoryId);
    }
}
