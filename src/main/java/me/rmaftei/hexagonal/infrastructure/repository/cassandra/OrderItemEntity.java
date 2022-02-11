package me.rmaftei.hexagonal.infrastructure.repository.cassandra;

import lombok.Data;
import me.rmaftei.hexagonal.domain.OrderItem;
import me.rmaftei.hexagonal.domain.Product;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@UserDefinedType("order_item")
public class OrderItemEntity {

    private UUID productId;

    private String productName;

    private BigDecimal productPrice;

    public OrderItemEntity() {
    }

    public OrderItemEntity(final OrderItem orderItem) {
        this.productId = orderItem.getProductId();
        this.productPrice = orderItem.getProductPrice();
        this.productName = orderItem.getProductName();
    }

    public OrderItem toOrderItem() {
        return new OrderItem(new Product(productId, productPrice, productName));
    }

}
