package com.metacoding.product.product;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{productId}")
    public ProductResponse getProduct(@PathVariable("productId") int productId) {
        return productService.findById(productId);
    }

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.findAll();
    }

    @PostMapping("/{id}/decrease")
    public void decreaseQuantity(@PathVariable int id, @RequestParam int quantity) {
        productService.decreaseQuantity(id, quantity);
    }
}
