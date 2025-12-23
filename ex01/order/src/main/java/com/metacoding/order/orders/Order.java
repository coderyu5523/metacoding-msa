package com.metacoding.order.orders;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "order_tb")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private int productId;
    private int quantity;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    private Order(int userId, int productId, int quantity, String status) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public static Order create(int userId, int productId, int quantity) {
        if (userId <= 0) {
            throw new RuntimeException("User ID must be greater than 0");
        }
        if (productId <= 0) {
            throw new RuntimeException("Product ID must be greater than 0");
        }
        if (quantity <= 0) {
            throw new RuntimeException("Quantity must be greater than 0");
        }
        return new Order(userId, productId, quantity, "PENDING");
    }

    public void updateStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            throw new RuntimeException("Status cannot be null or empty");
        }
        this.status = status;
        this.updatedAt = LocalDateTime.now();
    }
}






