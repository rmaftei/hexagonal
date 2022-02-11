package me.rmaftei.hexagonal.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Product {

    private final UUID id;

    private final BigDecimal price;

    private final String name;

}
