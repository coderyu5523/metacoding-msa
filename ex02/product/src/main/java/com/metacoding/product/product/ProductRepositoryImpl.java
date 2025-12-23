package com.metacoding.product.product;

import com.metacoding.product.domain.product.Product;
import com.metacoding.product.domain.product.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryImpl extends JpaRepository<Product, Integer>, ProductRepository {
}
