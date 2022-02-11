package me.rmaftei.hexagonal.infrastructure.configuration;

import me.rmaftei.hexagonal.domain.repository.OrderRepository;
import me.rmaftei.hexagonal.domain.service.DomainOrderService;
import me.rmaftei.hexagonal.domain.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    OrderService orderService(final OrderRepository orderRepository) {
        return new DomainOrderService(orderRepository);
    }

}
