package com.metacoding.order.clients;

import com.metacoding.order.clients.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service", url = "${feign.product.url}")
public interface ProductClient {
    
    @GetMapping("/api/products/{productId}")
    ProductResponse getProduct(@PathVariable("productId") int productId);
    
    @PostMapping("/api/products/{id}/decrease")
    void decreaseQuantity(@PathVariable("id") int id, @RequestParam("quantity") int quantity);
}


