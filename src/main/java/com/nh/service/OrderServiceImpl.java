/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.service;

import com.nh.dao.OrderDao;
import com.nh.model.Order;
import com.nh.model.OrderStatus;
import com.nh.model.OrderType;
import com.nh.model.Product;
import com.nh.model.User;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nfreitas
 */
@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService{
    
    @Autowired
    private OrderDao dao;

    public Order findById(int id) {
        return dao.findById(id);
    }

    public void saveOrder(Order order) {
        dao.saveOrder(order);
    }

    public void updateOrder(Order order) {
        Order entity = dao.findById(order.getId());
        if(entity!=null){
            entity.setDateIn(order.getDateIn());
            entity.setDateOut(order.getDateOut());
            entity.setOrderStatus(order.getOrderStatus());
            entity.setOrderType(order.getOrderType());
            entity.setProduct(order.getProduct());
            entity.setQuantity(order.getQuantity());
            entity.setUser(order.getUser());
        }
    }

    public void deleteOrderById(int id) {
        dao.deleteOrderById(id);
    }

    public List<Order> findAllOrders() {
        return dao.findAllOrders();
    }

    public List<Order> findOrdersByStatus(OrderStatus orderStatus) {
        return dao.findOrdersByStatus(orderStatus);
    }

    public List<Order> findOrdersByType(OrderType orderType) {
        return dao.findOrdersByType(orderType);
    }

    public List<Order> findOrdersByProduct(Product product) {
        return dao.findOrdersByProduct(product);
    }

    public List<Order> findOrdersByDateIn(Date date) {
        return dao.findOrdersByDateIn(date);
    }

    public List<Order> findOrdersByUser(User user) {
        return dao.findOrdersByUser(user);
    }
    
}
