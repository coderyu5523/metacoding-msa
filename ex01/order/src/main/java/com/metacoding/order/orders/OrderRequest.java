package com.metacoding.order.orders;

public class OrderRequest {
    public record SaveDTO(
        int userId,
        int productId,
        int quantity
    ) {
        public SaveDTO(Order order) {
            this(order.getUserId(), order.getProductId(), order.getQuantity());
        }
    }
}