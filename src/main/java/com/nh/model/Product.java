/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author nfreitas
 */
@Entity
@Table(name="product")
public class Product {
    
    private int id;
    private String designation;
    private int quantity;
    private float price;
    private ProductType procuctType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @NotEmpty
    @Size(min=3, max=45)
    @Column(name = "designation", nullable = false)
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name = "price", nullable = false)
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    @ManyToOne()
    @JoinColumn(name="productType_id")
    public ProductType getProcuctType() {
        return procuctType;
    }
    public void setProcuctType(ProductType procuctType) {
        this.procuctType = procuctType;
    }
    
    
    
}
