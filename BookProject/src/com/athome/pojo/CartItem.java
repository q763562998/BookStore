package com.athome.pojo;

public class CartItem {

    int id;
    String name;
    int number;
    double unitPrice;
    double totalPrice;

    public CartItem(String name, int number, double unitPrice, double totalPrice) {
        this.name = name;
        this.number = number;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public CartItem(int id, String name, int number, double unitPrice, double totalPrice) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public CartItem() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
