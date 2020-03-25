package com.athome.service.impl;

import com.athome.dao.OrderItemDao;
import com.athome.dao.impl.OrderItemImpl;
import com.athome.pojo.OrderItem;

public class OrderItemService  implements OrderItemImpl {
    OrderItemDao orderItemDao=new OrderItemDao();
    @Override
    public void saveOrderItem(OrderItem orderItem) {
        orderItemDao.saveOrderItem(orderItem);
    }
}
