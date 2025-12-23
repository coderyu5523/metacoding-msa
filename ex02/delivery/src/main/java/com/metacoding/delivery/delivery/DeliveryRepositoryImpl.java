package com.metacoding.delivery.service;

import com.metacoding.delivery.domain.delivery.Delivery;
import com.metacoding.delivery.domain.delivery.DeliveryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepositoryImpl extends JpaRepository<Delivery, Integer>, DeliveryRepository {
}
