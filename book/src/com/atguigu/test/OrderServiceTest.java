package com.atguigu.test;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.pojo.OrderItem;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "c", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(3, "pythons", 1, new BigDecimal(1000), new BigDecimal(1000)));
        OrderService orderService=new OrderServiceImpl();
        System.out.println(orderService.createOrder(cart, 1));
    }
}