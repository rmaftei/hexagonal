package me.rmaftei.hexagonal.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.*;

@Data
public class Order {
    private UUID id;
    private OrderStatus status;
    private List<OrderItem> orderItems;
    private BigDecimal price;

    public Order() {
    }

    public Order(UUID id) {
        this.id = id;
    }

    public Order(final UUID id, final Product product) {
        this.id = id;
        this.orderItems = new ArrayList<>(Collections.singletonList(new OrderItem(product)));
        this.status = OrderStatus.CREATED;
        this.price = product.getPrice();
    }

    public void complete() {
        validateState();
        this.status = OrderStatus.COMPLETED;
    }

    public void addOrder(Product product) {
        validateState();
        validateProduct(product);
        orderItems.add(new OrderItem(product));
        price = price.add(product.getPrice());
    }

    public void removeOrder(UUID id) {
        validateState();
        final OrderItem orderItem = getOrderItem(id);
        orderItems.remove(orderItem);

        price = price.subtract(orderItem.getProductPrice());
    }

    private OrderItem getOrderItem(final UUID id) {
        return orderItems.stream()
                .filter(orderItem -> orderItem.getProductId()
                        .equals(id))
                .findFirst()
                .orElseThrow(() -> new DomainException("Product with " + id + " doesn't exist."));
    }

    private void validateState() {
        if (OrderStatus.COMPLETED.equals(status)) {
            throw new DomainException("The order is in completed state.");
        }
    }

    private void validateProduct(final Product product) {
        if (product == null) {
            throw new DomainException("The product cannot be null.");
        }
    }


}
