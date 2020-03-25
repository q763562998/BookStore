package com.athome.test;

import com.athome.pojo.OrderItem;
import com.athome.service.OrderServiceImpl;
import com.athome.service.impl.OrderItemService;
import com.athome.service.impl.OrderService;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderItemServiceTest {
    OrderItemService orderItemService=new OrderItemService();
    @Test
    public void saveOrderItem() {
        OrderItem item = new OrderItem(4, "test02", 2, 20, 30, "test04");
        orderItemService.saveOrderItem(item);
    }
}