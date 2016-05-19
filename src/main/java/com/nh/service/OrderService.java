/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.service;

import com.nh.model.Order;
import com.nh.model.OrderStatus;
import com.nh.model.OrderType;
import com.nh.model.Product;
import com.nh.model.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nfreitas
 */
public interface OrderService {
    
        Order findById(int id);

	void saveOrder(Order order);
        
        void updateOrder(Order order);
        
        void deleteOrderById(int id);
	
	List<Order> findAllOrders();
        
        List<Order> findOrdersByStatus(OrderStatus orderStatus);
        
        List<Order> findOrdersByType(OrderType orderType);
        
        List<Order> findOrdersByProduct(Product product);
        
        List<Order> findOrdersByDateIn(Date date);
        
        List<Order> findOrdersByUser(User user);
    
}
