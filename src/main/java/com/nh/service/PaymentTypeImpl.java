/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.service;

import com.nh.dao.PaymentTypeDao;
import com.nh.model.PaymentType;
import java.util.List;
import javax.transaction.TransactionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hvsousa
 */
@Service("paymentTypeService")
@Transactional
public class PaymentTypeImpl implements PaymentTypeService{
    
    @Autowired
    private PaymentTypeDao paymentTypeDao;
    

    public void addPaymentType(PaymentType pt) {
        this.paymentTypeDao.addPaymentType(pt);
    }

    public PaymentType getPaymentTypeById(int id) {
        return this.paymentTypeDao.getPaymentTypeById(id);
    }

    public List<PaymentType> listAllPaymentsTypes() {
       return this.paymentTypeDao.listAllPaymentsTypes();
    }

    public void deletePaymentTypeById(int id) {
        this.paymentTypeDao.deletePaymentTypeById(id);
    }
    
}
