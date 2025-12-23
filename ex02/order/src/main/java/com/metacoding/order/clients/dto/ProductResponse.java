package com.metacoding.order.clients.dto;

public record ProductResponse(
    int id,
    String productName,
    int quantity,
    Long price,
    String status
) {
}


