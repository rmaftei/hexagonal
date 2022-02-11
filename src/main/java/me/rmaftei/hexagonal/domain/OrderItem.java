package me.rmaftei.hexagonal.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class OrderItem {
    private UUID productId;
    private BigDecimal productPrice;
    private String productName;

    public OrderItem(Product product) {
        this.productId = product.getId();
        this.productPrice = product.getPrice();
        this.productName = product.getName();
    }

}
