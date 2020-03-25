package com.athome.pojo;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private  String orderNumber;
    private  String orderTime;
    private  double orderTotalMoney;
    private  int    status=0;//0代表未发货，1代表已发货
    private  int    userId;
    private ArrayList<OrderItem> orderItem=new ArrayList();

    public Order(String orderNumber, String orderTime, double orderTotalMoney, int status, int userId) {
        this.orderNumber = orderNumber;
        this.orderTime = orderTime;
        this.orderTotalMoney = orderTotalMoney;
        this.status = status;
        this.userId = userId;
    }

    public Order() {
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public double getOrderTotalMoney() {
        return orderTotalMoney;
    }

    public void setOrderTotalMoney(double orderTotalMoney) {
        this.orderTotalMoney = orderTotalMoney;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Order(String orderNumber, String orderTime, double orderTotalMoney, int status, int userId, ArrayList<OrderItem> orderItem) {
        this.orderNumber = orderNumber;
        this.orderTime = orderTime;
        this.orderTotalMoney = orderTotalMoney;
        this.status = status;
        this.userId = userId;
        this.orderItem = orderItem;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", orderTotalMoney=" + orderTotalMoney +
                ", status=" + status +
                ", userId=" + userId +
                ", orderItem=" + orderItem +
                '}';
    }
}
