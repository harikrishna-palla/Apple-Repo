package com.apple.product.controller;

import com.apple.product.model.Product;
import com.apple.product.model.ProductCategory;
import com.apple.product.service.ProductCategoryService;
import com.apple.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductCategoryService productCategoryService;
    @GetMapping("/product")
    public List<Product> getAllprodList() {
        return productService.findProductList();
    }
    @GetMapping("/product/{productID}")
    public Product getProdById(@PathVariable int productID) {
        return productService.findProductById(productID);
    }
    @PostMapping("/prodCategory/{prodCategoryID}/product")
    public void addProducts(@RequestBody Product product, @PathVariable int prodCategoryID) {
        ProductCategory productCategory = productCategoryService.findProdCategoryById(prodCategoryID);
        product.setProductCategory(productCategory);
        productService.insertProducts(product);
    }
    @PutMapping("/prodCategory/{prodCategoryID}/product")
    public void updateProducts(@RequestBody Product product, @PathVariable int prodCategoryID) {
        ProductCategory productCategory = productCategoryService.findProdCategoryById(prodCategoryID);
        product.setProductCategory(productCategory);
        productService.updateProducts(product);
    }
    @DeleteMapping("/product")
    public void deleteProducts(@RequestBody Product product) {
        productService.deleteProducts(product);
    }
    @DeleteMapping("/product/{productId}")
    public void deleteProductById(@PathVariable int productId) {
        productService.deleteProductById(productId);
    }
}
