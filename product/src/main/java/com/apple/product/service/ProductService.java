package com.apple.product.service;

import com.apple.product.model.Product;
import com.apple.product.model.ProductCategory;
import com.apple.product.repository.ProductCategoryRepository;
import com.apple.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public List<Product> findProductList() {
        List<Product> products = (List<Product>) productRepository.findAll();
        return products;
    }
    public Product findProductById(int productId){
        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isPresent()) {
            return productOptional.get();
        }
        else {
            return null;
        }
    }
public void insertProducts(Product product) {
        productRepository.save(product);
    }
    public void updateProducts(Product product) {
        productRepository.save(product);
    }
    public void deleteProducts(Product product) {
        productRepository.delete(product);
    }
    public void deleteProductById(int productId) {
        productRepository.deleteById(productId);
    }
}
