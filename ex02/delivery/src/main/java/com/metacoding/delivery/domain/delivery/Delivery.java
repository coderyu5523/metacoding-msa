package com.metacoding.delivery.domain.delivery;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "delivery_tb")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int orderId;
    private String address;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Delivery(int orderId, String address, String status) {
        this.orderId = orderId;
        this.address = address;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public static Delivery create(int orderId, String address) {
        if (orderId <= 0) {
            throw new RuntimeException("Order ID must be greater than 0");
        }
        if (address == null || address.trim().isEmpty()) {
            throw new RuntimeException("Address cannot be null or empty");
        }
        return new Delivery(orderId, address, "PENDING");
    }

    public void updateStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            throw new RuntimeException("Status cannot be null or empty");
        }
        this.status = status;
        this.updatedAt = LocalDateTime.now();
    }
}






