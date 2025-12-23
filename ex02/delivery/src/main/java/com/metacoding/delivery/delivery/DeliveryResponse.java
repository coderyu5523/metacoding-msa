package com.metacoding.delivery.delivery;

import com.metacoding.delivery.domain.delivery.Delivery;
import java.time.LocalDateTime;

public record DeliveryResponse(
    int id,
    int orderId,
    String address,
    String status,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
    public static DeliveryResponse from(Delivery delivery) {
        return new DeliveryResponse(
            delivery.getId(),
            delivery.getOrderId(),
            delivery.getAddress(),
            delivery.getStatus(),
            delivery.getCreatedAt(),
            delivery.getUpdatedAt()
        );
    }
}
