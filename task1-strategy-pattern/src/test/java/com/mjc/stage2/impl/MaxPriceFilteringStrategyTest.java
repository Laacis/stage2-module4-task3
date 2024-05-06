package com.mjc.stage2.impl;

import com.mjc.stage2.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaxPriceFilteringStrategyTest {
    MaxPriceFilteringStrategy strategy;
    @BeforeEach
    public void build() {
        strategy = new MaxPriceFilteringStrategy(10.00);
    }

    @Test
    public void MaxPriceFilteringStrategyFilterReturnTrue() {
        Product product = new Product("Test product", 09.99, "TEST");
        assert strategy.filter(product) : "Return expected to be True, but was: " + strategy.filter(product);

    }
    @Test
    public void MaxPriceFilteringStrategyFilterReturnFalse() {
        Product product = new Product("Test product", 19.99, "TEST");
        assert !strategy.filter(product) : "Return expected to be False, but was: " + strategy.filter(product);
    }
}
