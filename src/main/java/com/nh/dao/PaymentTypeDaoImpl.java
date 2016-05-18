/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.dao;

import com.nh.model.PaymentType;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hvsousa
 */
@Repository("paymentTypeDao")
public class PaymentTypeDaoImpl extends AbstractDao<Integer, PaymentType> implements PaymentTypeDao{

    public void addPaymentType(PaymentType pt) {
        this.persist(pt);
    }

    public PaymentType getPaymentTypeById(int id) {
       return this.getByKey(id);
    }

    public List<PaymentType> listAllPaymentsTypes() {
        Criteria criteria = createEntityCriteria();
        return (List<PaymentType>) criteria.list();
    }

    public void deletePaymentTypeById(int id) {
        this.deleteById(id);
    }
    
    
}
