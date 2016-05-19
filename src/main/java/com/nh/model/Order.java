/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author nfreitas
 */
@Entity
@Table(name="order")
public class Order {
    
    private int id;
    private Date dateIn;
    private Date dateOut;
    private int quantity;
    private OrderStatus orderStatus;
    private OrderType orderType;
    private Product product;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "dateIn", nullable = false)
    public Date getDateIn() {
        return dateIn;
    }
    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    @Column(name = "dateOut", nullable = false)
    public Date getDateOut() {
        return dateOut;
    }
    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @ManyToOne()
    @JoinColumn(name="orderStatus_id")
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @ManyToOne()
    @JoinColumn(name="orderType_id")
    public OrderType getOrderType() {
        return orderType;
    }
    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    @ManyToOne()
    @JoinColumn(name="product_id")
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne()
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
    
    
    
}
