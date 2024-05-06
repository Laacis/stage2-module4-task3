package com.mjc.stage2;

import com.mjc.stage2.impl.ManufactureFilteringStrategy;
import com.mjc.stage2.impl.MaxPriceFilteringStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShopStockTest {
    List<Product> productList;
    ShopStock shopStock;
    @BeforeEach
    public void build() {
        productList = new ArrayList<>();
        Product p1 = new Product("product One", 10.01, "APPLE");
        Product p2 = new Product("product Two", 20.01, "APPLE");
        Product p3 = new Product("product Tree", 20.01, "MONGO");

        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        shopStock = new ShopStock(productList);
    }

    @Test
    public void executeFilteringStrategyReturnsListOfFoundProductsUsingManufactureFilteringStrategy() {
        ManufactureFilteringStrategy strategy = new ManufactureFilteringStrategy("MONGO");
        List<Product> result = shopStock.executeFilteringStrategy(strategy);
        assert result.size() == 1 : "Expected List length 1, but was: " + result.size();
    }

    @Test
    public void executeFilteringStrategyReturnsListOfFoundProductsUsingMaxPriceFilteringStrategy() {
        MaxPriceFilteringStrategy strategy = new MaxPriceFilteringStrategy(10.10);
        List<Product> result = shopStock.executeFilteringStrategy(strategy);
        assert result.size() == 1 : "Expected List length 1, but was: " + result.size();
    }

    @Test
    public void executeFilteringStrategyReturnsEmptyListNoManufacturerFound() {
        ManufactureFilteringStrategy strategy = new ManufactureFilteringStrategy("FAIL");
        List<Product> result = shopStock.executeFilteringStrategy(strategy);
        assert  result.isEmpty() : "Result list should be empty, but was: " + result.size();
    }    @Test
    public void executeFilteringStrategyReturnsEmptyListNoMaxPriceFound() {
        MaxPriceFilteringStrategy strategy = new MaxPriceFilteringStrategy(5.90);
        List<Product> result = shopStock.executeFilteringStrategy(strategy);
        assert  result.isEmpty() : "Result list should be empty, but was: " + result.size();
    }
}
