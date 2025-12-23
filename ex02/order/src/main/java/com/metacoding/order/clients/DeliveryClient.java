package com.metacoding.order.clients;

import com.metacoding.order.clients.dto.DeliveryRequest;
import com.metacoding.order.clients.dto.DeliveryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "delivery-service", url = "${feign.delivery.url}")
public interface DeliveryClient {
    
    @PostMapping("/api/deliveries")
    DeliveryResponse createDelivery(@RequestBody DeliveryRequest request);
    
    @GetMapping("/api/deliveries/{id}")
    DeliveryResponse getDelivery(@PathVariable("id") int id);
}


