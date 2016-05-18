/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.dao;

import com.nh.model.PaymentType;
import java.util.List;

/**
 *
 * @author hvsousa
 */
public interface PaymentTypeDao {
    void addPaymentType(PaymentType pt);
    PaymentType getPaymentTypeById(int id);
    List<PaymentType> listAllPaymentsTypes();
    void deletePaymentTypeById(int id);
}
