package com.metacoding.order.orders;

import com.metacoding.order.domain.order.Order;
import com.metacoding.order.domain.order.OrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryImpl extends JpaRepository<Order, Integer>, OrderRepository {
}
