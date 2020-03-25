package com.athome.web;

import com.athome.pojo.*;
import com.athome.service.impl.BookService;
import com.athome.service.impl.OrderItemService;
import com.athome.service.impl.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class OrderServlet extends BaseBookServlet {
    OrderService orderService=new OrderService();
//    ArrayList<Order> arrayList=new ArrayList<>();
    OrderItemService orderItemService=new OrderItemService();
    BookService bookService=new BookService();
    public void create(HttpServletRequest req, HttpServletResponse res) throws IOException {

        User user = (User) req.getSession().getAttribute("user");

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (user==null){
            req.getRequestDispatcher("/pages/user/login.jsp");
            return;
        }


        String orderNumber=System.currentTimeMillis()+user.getUsername();
        String orderTime=new Date()+"";
        // 订单单号，订单时间，    订单总金额cart.totalNumber   订单状态0  用户名user.name
        Order order = new Order(orderNumber, orderTime, cart.getTotalMoney(), 0, user.getId());
        orderService.saveOrder(order);

//        int j=12/0;
        for (int i = 0; i < cart.getCartItem().size(); i++) {
            //int id, String name, int number, double unitPrice, double totalPrice, String orderNumber
            OrderItem item = new OrderItem(cart.getCartItem().get(i).getId(), cart.getCartItem().get(i).getName(), cart.getCartItem().get(i).getNumber(), cart.getCartItem().get(i).getUnitPrice(), cart.getCartItem().get(i).getTotalPrice(), orderNumber);
            //注意

            orderItemService.saveOrderItem(item);
            Book book = bookService.queryForOne(cart.getCartItem().get(i).getId());
            book.setSales(cart.getCartItem().get(i).getNumber()+book.getSales());
            book.setStock(book.getStock()-cart.getCartItem().get(i).getNumber());
            bookService.updateBookService(book);


        }
//        arrayList.add(order);
        req.getSession().setAttribute("order",order);
        req.getSession().removeAttribute("cart");
//        Pages page = (Pages) req.getAttribute("page");
//        cart.getCartItem()

//        System.out.println("保存成功");
        res.sendRedirect("http://localhost:8080/BookProject/pages/cart/checkout.jsp");
    }
}
