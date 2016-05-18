/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.service;

import com.nh.model.OrderType;
import java.util.List;

/**
 *
 * @author nfreitas
 */
public interface OrderTypeService {
    
    OrderType findById(int id);

    void saveOrderType(OrderType orderType);
        
    void updateOrderType(OrderType orderType);
    
    void deleteOrderTypeById(int id);
    
    List<OrderType> findAllOrderType();
    
    OrderType findOrderTypeByDesignation(String designation); 
    
}
