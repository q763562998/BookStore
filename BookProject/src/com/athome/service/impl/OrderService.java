package com.athome.service.impl;

import com.athome.dao.OrderDao;
import com.athome.pojo.Cart;
import com.athome.pojo.Order;
import com.athome.service.OrderServiceImpl;

public class OrderService implements OrderServiceImpl {

    OrderDao orderDao=new OrderDao();
    @Override
    public void saveOrder(Order order) {
        orderDao.saveOrder(order);
    }




}
