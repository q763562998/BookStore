package com.athome.web;

import com.athome.pojo.Book;
import com.athome.pojo.Cart;
import com.athome.pojo.CartItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartService extends BaseBookServlet {


    public void  add(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String name = req.getParameter("name");
        int id = Integer.parseInt(req.getParameter("id"));
        double price = Double.parseDouble(req.getParameter("price"));
        boolean flag=false;

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart!=null) {
            for (CartItem cartItem: cart.getCartItem()
                 ) {
                if (cartItem.getId()==id){
                    //表明加了同样的商品，只需要修改商品数量与总价

                    cartItem.setNumber(cartItem.getNumber()+1);
                    cartItem.setTotalPrice(cartItem.getTotalPrice()+cartItem.getUnitPrice());
                    flag=true;//表明 购物车中有一模一样的
                }

            }
            if (flag==false){
                CartItem item = new CartItem(id, name, 1, price, price);
                cart.getCartItem().add(item);
                req.getSession().setAttribute("last",item);
            }
            req.getSession().setAttribute("cart",cart);
        }
        else {
            Cart cart1 = new Cart();
            CartItem item = new CartItem(id, name, 1, price, price);
            req.getSession().setAttribute("last",item);
            cart1.getCartItem().add(item);
            req.getSession().setAttribute("cart",cart1);
        }


        String referer = req.getHeader("Referer");
//        System.out.println("原来的界面"+referer);
//        res.sendRedirect("http://localhost:8080/BookProject/pages/cart/cart.jsp");

        //req.getHeader("Referer") 是指原来的界面
        res.sendRedirect(referer);
    }
    public void  delete(HttpServletRequest req,HttpServletResponse res) throws IOException {

        int  id = Integer.parseInt(req.getParameter("id"));
        Cart cart= (Cart) req.getSession().getAttribute("cart");
        int index=0;
        for (int i = 0; i <cart.getCartItem().size(); i++) {
            if (cart.getCartItem().get(i).getId()==id){
                index=i;
            }
        }
        cart.getCartItem().remove(index);
//        req.getSession().invalidate();
        req.getSession().removeAttribute("cart");
        req.getSession().setAttribute("cart",cart);
        res.sendRedirect("http://localhost:8080/BookProject/pages/cart/cart.jsp");
//        req.getRequestDispatcher("/pages/cart/cart.jsp");

    }
    public void clear(HttpServletRequest req,HttpServletResponse res) throws IOException {
        Cart cart= (Cart) req.getSession().getAttribute("cart");
        cart.getCartItem().clear();
        req.getSession().invalidate();
        res.sendRedirect("http://localhost:8080/BookProject/pages/cart/cart.jsp");
    }

    public void update(HttpServletRequest req,HttpServletResponse res) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int count = Integer.parseInt(req.getParameter("count"));
        int index=0;
        Cart cart= (Cart) req.getSession().getAttribute("cart");
        for (int i = 0; i <cart.getCartItem().size() ; i++) {
            if (cart.getCartItem().get(i).getId()==id){
                index=i;
            }
        }

            cart.getCartItem().get(index).setNumber(count);
            cart.getCartItem().get(index).setTotalPrice(cart.getCartItem().get(index).getUnitPrice()*cart.getCartItem().get(index).getNumber());

//        req.getSession().invalidate();
        req.getSession().removeAttribute("cart");
        req.getSession().setAttribute("cart",cart);
        String referer = req.getHeader("Referer");
        res.sendRedirect(referer);
    }
}
