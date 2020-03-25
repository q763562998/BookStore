package com.athome.test;

import com.athome.pojo.Order;
import com.athome.service.impl.OrderService;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderServiceTest {
    OrderService orderService=new OrderService();
    @Test
    public void saveOrder() {

        Order order = new Order("test04", "20202033", 100, 0, 2);
        orderService.saveOrder(order);
    }
}