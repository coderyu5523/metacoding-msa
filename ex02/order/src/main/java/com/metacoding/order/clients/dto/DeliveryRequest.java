package com.metacoding.order.clients.dto;

public record DeliveryRequest(
    int orderId,
    String address
) {
}


