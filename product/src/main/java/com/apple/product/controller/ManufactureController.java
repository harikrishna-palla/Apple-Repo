package com.apple.product.controller;

import com.apple.product.model.Manufacture;
import com.apple.product.model.Product;
import com.apple.product.model.ProductCategory;
import com.apple.product.service.ManufactureService;
import com.apple.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManufactureController {
    @Autowired
    ManufactureService manufactureService;
    @Autowired
    ProductService productService;
    @GetMapping("/manufacture")
    public List<Manufacture> getAllmanufactureList() {
        return manufactureService.findManufactureList();
    }
    @GetMapping("/manufacture/{manufactureID}")
    public Manufacture getProdById(@PathVariable int manufactureID) {
        return manufactureService.findManufactureById(manufactureID);
    }
    @PostMapping("/product/{productID}/manufacture")
    public void addManufactures(@RequestBody Manufacture manufacture, @PathVariable int productID) {
        Product product = productService.findProductById(productID);
        manufacture.setProduct(product);
        manufactureService.insertmanufactures(manufacture);
    }
    @PutMapping("/product/{productID}/manufacture")
    public void updateManufactures(@RequestBody Manufacture manufacture, @PathVariable int productID) {
        Product product = productService.findProductById(productID);
        manufacture.setProduct(product);
        manufactureService.updateManufactures(manufacture);
    }
    @DeleteMapping("/manufacture")
    public void deleteManufactures(@RequestBody Manufacture manufacture) {
        manufactureService.deleteManufactures(manufacture);
    }
    @DeleteMapping("/manufacture/{manufactureId}")
    public void deleteManufacturesById(@PathVariable int manufactureId) {
        manufactureService.deleteManufactureById(manufactureId);
    }
}
