/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.service;

import com.nh.model.OrderStatus;
import java.util.List;

/**
 *
 * @author nfreitas
 */
public interface OrderStatusService {
    
        OrderStatus findById(int id);

	void saveOrderStatus(OrderStatus orderStatus);
        
        void updateOrderStatus(OrderStatus orderStatus);
        
        void deleteOrderStatusById(int id);
	
	List<OrderStatus> findAllOrderStatus();
        
        OrderStatus findOrderStatusByDesignation(String designation);    
}
