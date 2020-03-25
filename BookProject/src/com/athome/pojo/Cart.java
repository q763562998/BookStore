package com.athome.pojo;

import java.util.ArrayList;

public class Cart {

    int totalNumber=0;
    double totalMoney=0;
    ArrayList<CartItem> cartItem=new ArrayList<>();

    public Cart() {
    }

    public Cart(int totalNumber, double totalMoney, ArrayList<CartItem> cartItem) {
        this.totalNumber = totalNumber;
        this.totalMoney = totalMoney;
        this.cartItem = cartItem;
    }

    public int getTotalNumber() {
        totalNumber=0;
        for (CartItem item:
             cartItem) {
            totalNumber+=item.getNumber();
        }
        return totalNumber;
    }



    public double getTotalMoney() {
        totalMoney=0;
        for (CartItem item:
             cartItem) {
            totalMoney+=item.getTotalPrice();
        }
        return totalMoney;
    }



    public ArrayList<CartItem> getCartItem() {

        return cartItem;
    }

    public void setCartItem(ArrayList<CartItem> cartItem) {
        this.cartItem = cartItem;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalNumber=" + getTotalNumber() +
                ", totalMoney=" + getTotalMoney() +
                ", cartItem=" + cartItem +
                '}';
    }
}
