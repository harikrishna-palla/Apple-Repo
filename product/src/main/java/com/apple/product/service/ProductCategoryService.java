package com.apple.product.service;

import com.apple.product.model.ProductCategory;
import com.apple.product.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    public List<ProductCategory> findProductCategoryList() {
        List<ProductCategory> productCategories = (List<ProductCategory>) productCategoryRepository.findAll();
        return productCategories;
    }
    public ProductCategory findProdCategoryById(int categoryId){
        Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findById(categoryId);
        if(productCategoryOptional.isPresent()) {
            return productCategoryOptional.get();
        }
        else {
            return null;
        }
    }
    public void insertProductCategories(ProductCategory productCategory) {
        productCategoryRepository.save(productCategory);
    }
    public void updateProductCategories(ProductCategory productCategory) {
        productCategoryRepository.save(productCategory);
    }
    public void deleteProductCategories(ProductCategory productCategory) {
        productCategoryRepository.delete(productCategory);
    }
    public void deleteProductCategoryById(int categoryId) {
        productCategoryRepository.deleteById(categoryId);
    }
}
