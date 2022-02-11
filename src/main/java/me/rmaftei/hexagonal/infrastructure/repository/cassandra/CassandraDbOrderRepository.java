package me.rmaftei.hexagonal.infrastructure.repository.cassandra;

import me.rmaftei.hexagonal.domain.Order;
import me.rmaftei.hexagonal.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Primary
public class CassandraDbOrderRepository implements OrderRepository {

    private SpringDataCassandraOrderRepository orderRepository;

    @Autowired
    public CassandraDbOrderRepository(SpringDataCassandraOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> findById(UUID id) {
        Optional<OrderEntity> byId = orderRepository.findById(id);

        OrderEntity orderEntity = byId.orElseThrow();

        return Optional.of(orderEntity.toOrder());
    }

    @Override
    public void save(Order order) {
        this.orderRepository.save(new OrderEntity(order));
    }
}
