package com.metacoding.delivery.delivery;

import com.metacoding.delivery.domain.delivery.Delivery;
import com.metacoding.delivery.domain.delivery.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    @Transactional
    public DeliveryResponse createDelivery(int orderId, String address) {
        Delivery delivery = Delivery.create(orderId, address);
        Delivery savedDelivery = deliveryRepository.save(delivery);
        return DeliveryResponse.from(savedDelivery);
    }

    public DeliveryResponse findById(int id) {
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery not found with id: " + id));
        return DeliveryResponse.from(delivery);
    }
}
