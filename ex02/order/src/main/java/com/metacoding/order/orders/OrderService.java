package com.metacoding.order.orders;

import com.metacoding.order.domain.order.Order;
import com.metacoding.order.domain.order.OrderRepository;
import com.metacoding.order.clients.ProductClient;
import com.metacoding.order.clients.DeliveryClient;
import com.metacoding.order.clients.dto.ProductResponse;
import com.metacoding.order.clients.dto.DeliveryRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductClient productClient;
    private final DeliveryClient deliveryClient;

    @Transactional
    public OrderResponse createOrder(OrderRequest request) {
        // 1. 주문 insert
        Order order = Order.create(
                request.userId(),
                request.productId(),
                request.quantity()
        );
        Order savedOrder = orderRepository.save(order);

        // 2. 상품 api 호출
        // 3. 상품에서 상품 조회
        ProductResponse product = productClient.getProduct(request.productId());
        if (product == null) {
            throw new RuntimeException("Product not found with id: " + request.productId());
        }
        
        // 재고 확인
        if (product.quantity() < request.quantity()) {
            throw new RuntimeException("Insufficient stock. Available: " + product.quantity() + ", Requested: " + request.quantity());
        }
        
        // 4. 상품 재고 -1
        productClient.decreaseQuantity(request.productId(), request.quantity());
        
        // 5. 배달 생성
        DeliveryRequest deliveryRequest = new DeliveryRequest(
                savedOrder.getId(),
                "Default Address"
        );
        deliveryClient.createDelivery(deliveryRequest);

        // 6. 주문 완료
        savedOrder.updateStatus("COMPLETED");
        Order completedOrder = orderRepository.save(savedOrder);

        return OrderResponse.from(completedOrder);
    }

    public OrderResponse findById(int id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        return OrderResponse.from(order);
    }
}
