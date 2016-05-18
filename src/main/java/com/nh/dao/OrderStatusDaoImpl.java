/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.dao;

import com.nh.model.OrderStatus;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nfreitas
 */
@Repository("orderStatusDao")
public class OrderStatusDaoImpl extends AbstractDao<Integer, OrderStatus> implements OrderStatusDao{

    public OrderStatus findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void saveOrderStatus(OrderStatus oderStatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteOrderStatusById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<OrderStatus> findAllOrderStatus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public OrderStatus findOrderStatusByDesignation(String designation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
