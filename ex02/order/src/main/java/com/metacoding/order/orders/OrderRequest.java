package com.metacoding.order.orders;

public record OrderRequest(
    int userId,
    int productId,
    int quantity
) {
}
