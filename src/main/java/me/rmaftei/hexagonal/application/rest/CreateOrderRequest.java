package me.rmaftei.hexagonal.application.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import me.rmaftei.hexagonal.domain.Product;

import javax.validation.constraints.NotNull;

public class CreateOrderRequest {
    @NotNull
    private final Product product;

    @JsonCreator
    public CreateOrderRequest(@JsonProperty("product") @NotNull final Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
