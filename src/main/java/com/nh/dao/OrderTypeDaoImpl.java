/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.dao;

import com.nh.model.OrderType;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nfreitas
 */
@Repository("orderTypeDao")
public class OrderTypeDaoImpl extends AbstractDao<Integer, OrderType> implements OrderTypeDao{

    public OrderType findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void saveOrderType(OrderType orderType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteOrderTypeById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<OrderType> findAllOrderTypes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public OrderType findOrderTypeByDesignation(String designation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
