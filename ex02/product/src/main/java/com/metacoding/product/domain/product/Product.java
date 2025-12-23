package com.metacoding.product.domain.product;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "product_tb")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private int quantity;
    private Long price;
    private String status;

    private Product(String productName, int quantity, Long price, String status) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public static Product create(String productName, int quantity, Long price, String status) {
        return new Product(productName, quantity, price, status);
    }

    public void decreaseQuantity(int quantity) {
        if (this.quantity < quantity) {
            throw new RuntimeException("Insufficient product quantity");
        }
        this.quantity -= quantity;
    }

    public void validateAndDecreaseQuantity(int quantity) {
        if (quantity <= 0) {
            throw new RuntimeException("Quantity must be greater than 0");
        }
        decreaseQuantity(quantity);
    }
}
