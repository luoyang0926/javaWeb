package com.atguigu.test;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {

        OrderItemDao orderItemDao=new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null, "java", 3, new BigDecimal(100), new BigDecimal(300), "123"));
        orderItemDao.saveOrderItem(new OrderItem(null, "javaScript", 3, new BigDecimal(100), new BigDecimal(300), "123"));
        orderItemDao.saveOrderItem(new OrderItem(null, "javaQuery", 3, new BigDecimal(100), new BigDecimal(300), "123"));
    }
}