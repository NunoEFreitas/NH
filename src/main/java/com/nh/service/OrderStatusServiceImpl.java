/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.service;

import com.nh.dao.OrderStatusDao;
import com.nh.model.OrderStatus;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nfreitas
 */
@Service("orderStatusService")
@Transactional
public class OrderStatusServiceImpl implements OrderStatusService{
    
    @Autowired
    private OrderStatusDao dao;

    public OrderStatus findById(int id) {
        return dao.findById(id);
    }

    public void saveOrderStatus(OrderStatus orderStatus) {
        dao.saveOrderStatus(orderStatus);
    }

    public void updateOrderStatus(OrderStatus orderStatus) {
        OrderStatus entity = dao.findById(orderStatus.getId());
        if(entity!=null){
            entity.setDesignation(orderStatus.getDesignation());
        }
    }

    public void deleteOrderStatusById(int id) {
        dao.deleteOrderStatusById(id);
    }

    public List<OrderStatus> findAllOrderStatus() {
        return dao.findAllOrderStatus();
    }

    public OrderStatus findOrderStatusByDesignation(String designation) {
        return dao.findOrderStatusByDesignation(designation);
    }
    
}
