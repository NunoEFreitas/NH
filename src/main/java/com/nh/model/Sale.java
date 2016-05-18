/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author hvsousa
 */

@Entity
@Table(name="sale")
public class Sale implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @NotEmpty
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="date")
    private Date date;
    
   @NotNull
   @Column(name="priceTotal")
   private float priceTotal;
   
   @Type(type="true_false")
   @Column(name="paid")
   private boolean paid;
   
   @OneToMany
   @JoinColumn(name="order_id")
   private Order order;
   
   @OneToMany
   @JoinColumn(name="orderProduct_product_id")
   private Order orderProduct;
   
   @OneToMany
   @JoinColumn(name="paymentType_id")
   private PaymentType paymentType;

    public Sale() {
    }

    public Sale(int id, Date date, float priceTotal, boolean paid, Order order, Order orderProduct, PaymentType paymentType) {
        this.id = id;
        this.date = date;
        this.priceTotal = priceTotal;
        this.paid = paid;
        this.order = order;
        this.orderProduct = orderProduct;
        this.paymentType = paymentType;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the priceTotal
     */
    public float getPriceTotal() {
        return priceTotal;
    }

    /**
     * @param priceTotal the priceTotal to set
     */
    public void setPriceTotal(float priceTotal) {
        this.priceTotal = priceTotal;
    }

    /**
     * @return the paid
     */
    public boolean isPaid() {
        return paid;
    }

    /**
     * @param paid the paid to set
     */
    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    /**
     * @return the paymentType
     */
    public PaymentType getPaymentType() {
        return paymentType;
    }

    /**
     * @param paymentType the paymentType to set
     */
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
   
   
   
   
   
}
