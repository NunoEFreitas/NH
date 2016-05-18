/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.dao;

import com.nh.model.OrderType;
import java.util.List;

/**
 *
 * @author nfreitas
 */
public interface OrderTypeDao {
    
        OrderType findById(int id);

	void saveOrderType(OrderType orderType);
        
        void deleteOrderTypeById(int id);
	
	List<OrderType> findAllOrderTypes();
        
        OrderType findOrderTypeByDesignation(String designation);
    
}
