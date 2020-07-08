package com.apple.product.service;

import com.apple.product.model.Manufacture;
import com.apple.product.model.Product;
import com.apple.product.repository.ManufactureRepository;
import com.apple.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufactureService {
    @Autowired
    ManufactureRepository manufactureRepository;
    public List<Manufacture> findManufactureList() {
        List<Manufacture> manufactures = (List<Manufacture>) manufactureRepository.findAll();
        return manufactures;
    }
    public Manufacture findManufactureById(int manufactureId){
        Optional<Manufacture> manufactureOptional = manufactureRepository.findById(manufactureId);
        if(manufactureOptional.isPresent()) {
            return manufactureOptional.get();
        }
        else {
            return null;
        }
    }
    public void insertmanufactures(Manufacture manufacture) {
        manufactureRepository.save(manufacture);
    }
    public void updateManufactures(Manufacture manufacture) {
        manufactureRepository.save(manufacture);
    }
    public void deleteManufactures(Manufacture manufacture) {
        manufactureRepository.delete(manufacture);
    }
    public void deleteManufactureById(int manufactureId) {
        manufactureRepository.deleteById(manufactureId);
    }
}
