package com.mjc.stage2.impl;

import com.mjc.stage2.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManufactureFilteringStrategyTest {
    private ManufactureFilteringStrategy strategy;
    private Product product;
    @BeforeEach
    public void build() {
        strategy = new ManufactureFilteringStrategy("test");
        product = new Product("text prod", 00.01, "test");
    }

    @Test
    public void ManufactureFilteringStrategyFilterReturnsTrue() {
        assert strategy.filter(product) : " Return expected to be True, but was " + strategy.filter(product);
    }

    @Test
    public void ManufactureFilteringStrategyFilterReturnsFalse() {
        product = new Product("text prod", 00.01, "fail");
        assert !strategy.filter(product) : " Return expected to be False, but was " + strategy.filter(product);
    }

    @Test
    public void ManufactureFilteringStrategyHandlesCaseSensitivity() {
        product = new Product("text prod", 00.01, "TEST");
        assert strategy.filter(product) : " Return expected to be True, but was " + strategy.filter(product);
    }
}
