package me.rmaftei.hexagonal.infrastructure.repository.mongo;

import me.rmaftei.hexagonal.domain.Order;
import me.rmaftei.hexagonal.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
//@Primary
public class MongoDbOrderRepository implements OrderRepository {

    private SpringDataMongoOrderRepository mongoOrderRepository;

    @Autowired
    public MongoDbOrderRepository(SpringDataMongoOrderRepository mongoOrderRepository) {
        this.mongoOrderRepository = mongoOrderRepository;
    }

    @Override
    public Optional<Order> findById(UUID id) {
        return mongoOrderRepository.findById(id);
    }

    @Override
    public void save(Order order) {
        mongoOrderRepository.save(order);
    }
}
