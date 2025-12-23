package com.metacoding.delivery.delivery;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {
    private final DeliveryService deliveryService;

    @PostMapping
    public DeliveryResponse createDelivery(@RequestBody DeliveryRequest request) {
        return deliveryService.createDelivery(request.orderId(), request.address());
    }

    @GetMapping("/{id}")
    public DeliveryResponse getDelivery(@PathVariable int id) {
        return deliveryService.findById(id);
    }
}
