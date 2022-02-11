package me.rmaftei.hexagonal.infrastructure.repository.mongo;

import me.rmaftei.hexagonal.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataMongoOrderRepository extends MongoRepository<Order, UUID> {
}
