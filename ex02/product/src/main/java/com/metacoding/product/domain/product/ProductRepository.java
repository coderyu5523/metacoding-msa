package com.metacoding.product.domain.product;

import java.util.Optional;
import java.util.List;

public interface ProductRepository {
    Optional<Product> findById(int id);
    Product save(Product product);
    List<Product> findAll();
}






