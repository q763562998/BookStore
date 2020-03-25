package com.athome.dao;

import com.athome.dao.impl.OrderDaoimpl;
import com.athome.pojo.Order;
import com.athome.pojo.Pages;

public class OrderDao  extends BaseDao  implements OrderDaoimpl {


    @Override
    public Pages getBookByprice(int min0, int max0, int num, int size) {
        return null;
    }

    @Override
    public void saveOrder(Order order) {
        String sql="insert into `order`(orderNumber,orderTime,orderTotalMoney,`status`,userId) values(?,?,?,?,?) ";
        update(sql,order.getOrderNumber(),order.getOrderTime(),order.getOrderTotalMoney(),order.getStatus(),order.getUserId());
        System.out.println("已保存订单");

    }
}
