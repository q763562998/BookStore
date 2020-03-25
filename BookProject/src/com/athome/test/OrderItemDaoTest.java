package com.athome.test;

import com.athome.dao.OrderDao;
import com.athome.dao.OrderItemDao;
import com.athome.pojo.OrderItem;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderItemDaoTest {
    OrderItemDao orderItemDao=new OrderItemDao();
    @Test
    public void saveOrderItem() {


        OrderItem item = new OrderItem(2,"test02",2,20,30,"test03");
        orderItemDao.saveOrderItem(item);

    }
}