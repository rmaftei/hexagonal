package me.rmaftei.hexagonal.domain.repository;

import me.rmaftei.hexagonal.domain.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    Optional<Order> findById(UUID id);

    void save(Order order);
}