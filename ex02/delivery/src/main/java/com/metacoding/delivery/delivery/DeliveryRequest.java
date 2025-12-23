package com.metacoding.delivery.delivery;

public record DeliveryRequest(
    int orderId,
    String address
) {
}
