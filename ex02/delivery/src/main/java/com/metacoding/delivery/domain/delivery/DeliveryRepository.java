package com.metacoding.delivery.domain.delivery;

import java.util.Optional;

public interface DeliveryRepository {
    Optional<Delivery> findById(int id);
    Delivery save(Delivery delivery);
}






