package com.athome.dao;

import com.athome.dao.impl.OrderItemImpl;
import com.athome.pojo.OrderItem;
import com.athome.pojo.Pages;

public class OrderItemDao extends BaseDao implements OrderItemImpl {
    @Override
    public Pages getBookByprice(int min0, int max0, int num, int size) {
        return null;
    }

    @Override
    public void saveOrderItem(OrderItem orderItem) {

        //需要先创建订单order 因为orderItem有关于order的外键
        String sql="insert into orderItem (id,`name`,number,unitPrice,totalPrice,orderNumber) values(?,?,?,?,?,?)";
        update(sql,orderItem.getId(),orderItem.getName(),orderItem.getNumber(),orderItem.getUnitPrice(),orderItem.getTotalPrice(),orderItem.getOrderNumber());
        System.out.println("item 保存成功");
    }
}
