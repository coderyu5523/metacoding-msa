package com.metacoding.product.products;

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

    @Builder
    private Product(String productName, int quantity, Long price, String status) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public void decreaseQuantity(int quantity) {
        if (this.quantity < quantity) {
            throw new RuntimeException("Insufficient product quantity");
        }
        this.quantity -= quantity;
    }

    public void updateStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            throw new RuntimeException("Status cannot be null or empty");
        }
        this.status = status;
    }
}
