package com.metacoding.product.product;

import com.metacoding.product.domain.product.Product;

public record ProductResponse(
    int id,
    String productName,
    int quantity,
    Long price,
    String status
) {
    public static ProductResponse from(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getProductName(),
            product.getQuantity(),
            product.getPrice(),
            product.getStatus()
        );
    }
}
