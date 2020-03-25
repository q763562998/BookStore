package com.athome.pojo;

public class OrderItem {
    private  int id;
    private String name;
    private  int number;
    private  double unitPrice;
    private double totalPrice;
    private String orderNumber;

    public OrderItem() {
    }

    public OrderItem(int id, String name, int number, double unitPrice, double totalPrice, String orderNumber) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.orderNumber = orderNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                ", orderNumber='" + orderNumber + '\'' +
                '}';
    }
}
