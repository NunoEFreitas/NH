/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.dao;

import com.nh.model.OrderStatus;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nfreitas
 */
@Repository("orderStatusDao")
public class OrderStatusDaoImpl extends AbstractDao<Integer, OrderStatus> implements OrderStatusDao{

    public OrderStatus findById(int id) {
       return getByKey(id);
    }

    public void saveOrderStatus(OrderStatus orderStatus) {
        persist(orderStatus);
    }

    public void deleteOrderStatusById(int id) {
        Query query = getSession().createSQLQuery("delete from orderStatus where id = :id");
	query.setString("id", Integer.toString(id));
        query.executeUpdate();
    }

    public List<OrderStatus> findAllOrderStatus() {
        Criteria criteria = createEntityCriteria();
        return (List<OrderStatus>) criteria.list();
    }

    public OrderStatus findOrderStatusByDesignation(String designation) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("designation", designation));
        return (OrderStatus) criteria.uniqueResult();    
    }
    
}
