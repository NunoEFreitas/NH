/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.service;

import com.nh.dao.OrderTypeDao;
import com.nh.model.OrderType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nfreitas
 */
@Service("orderTypeService")
@Transactional
public class OrderTypeServiceImpl implements OrderTypeService{
    
    @Autowired
    private OrderTypeDao dao;

    public OrderType findById(int id) {
        return dao.findById(id);
    }

    public void saveOrderType(OrderType orderType) {
        dao.saveOrderType(orderType);
    }

    public void updateOrderType(OrderType orderType) {
        OrderType entity = dao.findById(orderType.getId());
        if(entity!=null){
            entity.setDesignation(orderType.getDesignation());
        }
    }

    public void deleteOrderTypeById(int id) {
        dao.deleteOrderTypeById(id);
    }

    public List<OrderType> findAllOrderType() {
        return dao.findAllOrderTypes();
    }

    public OrderType findOrderTypeByDesignation(String designation) {
        return dao.findOrderTypeByDesignation(designation);
    }
    
}
