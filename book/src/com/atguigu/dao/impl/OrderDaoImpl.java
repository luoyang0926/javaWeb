package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(order_id,create_time,price,status,user_id)values(?,?,?,?,?)";
      return   update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }
}
