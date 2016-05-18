/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.dao;

import com.nh.model.OrderType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nfreitas
 */
@Repository("orderTypeDao")
public class OrderTypeDaoImpl extends AbstractDao<Integer, OrderType> implements OrderTypeDao{

    public OrderType findById(int id) {
        return getByKey(id);
    }

    public void saveOrderType(OrderType orderType) {
        persist(orderType);
    }

    public void deleteOrderTypeById(int id) {
        Query query = getSession().createSQLQuery("delete from orderType where id = :id");
	query.setString("id", Integer.toString(id));
        query.executeUpdate();
    }

    public List<OrderType> findAllOrderTypes() {
        Criteria criteria = createEntityCriteria();
        return (List<OrderType>) criteria.list();
    }

    public OrderType findOrderTypeByDesignation(String designation) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("designation", designation));
        return (OrderType) criteria.uniqueResult();
    }
    
}
