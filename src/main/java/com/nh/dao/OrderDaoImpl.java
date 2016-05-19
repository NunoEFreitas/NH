/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.dao;

import com.nh.model.Order;
import com.nh.model.OrderStatus;
import com.nh.model.OrderType;
import com.nh.model.Product;
import com.nh.model.User;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nfreitas
 */
@Repository("orderDao")
public class OrderDaoImpl extends AbstractDao<Integer, Order> implements OrderDao{

    public Order findById(int id) {
        return getByKey(id);
    }

    public void saveOrder(Order order) {
        persist(order);
    }

    public void deleteOrderById(int id) {
        Query query = getSession().createSQLQuery("delete from order where id = :id");
	query.setString("id", Integer.toString(id));
        query.executeUpdate();
    }

    public List<Order> findAllOrders() {
        Criteria criteria = createEntityCriteria();
        return (List<Order>) criteria.list();
    }

    public List<Order> findOrdersByStatus(OrderStatus orderStatus) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("orderStatus_id", orderStatus.getId()));
        return (List<Order>) criteria.list();  
    }

    public List<Order> findOrdersByType(OrderType orderType) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("orderType_id", orderType.getId()));
        return (List<Order>) criteria.list(); 
    }

    public List<Order> findOrdersByProduct(Product product) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("product_id", product.getId()));
        return (List<Order>) criteria.list(); 
    }

    public List<Order> findOrdersByDateIn(Date date) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dateIn", date));
        return (List<Order>) criteria.list(); 
    }

    public List<Order> findOrdersByUser(User user) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("user_id", user.getId()));
        return (List<Order>) criteria.list(); 
    }
    
}
