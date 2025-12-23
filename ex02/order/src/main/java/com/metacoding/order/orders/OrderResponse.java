package com.metacoding.order.orders;

import com.metacoding.order.domain.order.Order;
import java.time.LocalDateTime;

public record OrderResponse(
    int id,
    int userId,
    int productId,
    int quantity,
    String status,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
    public static OrderResponse from(Order order) {
        return new OrderResponse(
            order.getId(),
            order.getUserId(),
            order.getProductId(),
            order.getQuantity(),
            order.getStatus(),
            order.getCreatedAt(),
            order.getUpdatedAt()
        );
    }
}
