package com.demoshop.demoshop.repository;

import com.demoshop.demoshop.model.Product;
import com.demoshop.demoshop.model.ProductType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    public List<Product> findByProductType(ProductType productType);
}
