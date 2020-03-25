package com.athome.test;

import com.athome.dao.OrderDao;
import com.athome.pojo.Order;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderDaoTest {
    OrderDao orderDao=new OrderDao();
    @Test
    public void saveOrder() {
        Order order = new Order("test03","20202033",100,0,2);
        orderDao.saveOrder(order);
    }
}