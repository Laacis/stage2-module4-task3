package com.mjc.stage2.impl;

import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.warehouse.RectangleWarehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RectangleObserverTest {
    RectangleWarehouse warehouse = RectangleWarehouse.getInstance();
    Rectangle rectangle;
    @BeforeEach
    public void build(){
         rectangle = new Rectangle(1, 2, 3);
         warehouse.put(1, new RectangleValues(6, 12));
    }

    @Test
    public void RectangleObserverHandleEventSucceedToChangeWarehouse() {
        rectangle.addObserver(new RectangleObserver());
        rectangle.setSideA(1);
        rectangle.setSideB(2);
        assert  warehouse.get(1).getSquare() == 2 : "Square expected to be 2, but was : " + warehouse.get(1).getSquare();
    }

    @Test
    public void RectangleObserverHandleEventFailedToChangeWarehouse() {
        //missing observer
        rectangle.setSideA(1);
        rectangle.setSideB(2);
        assert warehouse.get(1).getSquare() == 6 : "Square expected to be 6, but was: " + warehouse.get(1).getSquare();
    }
}
