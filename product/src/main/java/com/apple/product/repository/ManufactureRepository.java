package com.apple.product.repository;

import com.apple.product.model.Manufacture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufactureRepository extends CrudRepository<Manufacture, Integer> {

}
