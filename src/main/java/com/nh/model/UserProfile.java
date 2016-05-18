/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;


/**
 *
 * @author hvsousa
 */
@Entity
@Table(name="userprofile")
public class UserProfile implements Serializable {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY )
   @Column(name="id")
   private int id;
   
   @NotEmpty
   @Size(min=5, max=40)
   @Column(name="designation")
   private String designation;

    public UserProfile() {
    }
   
    public UserProfile(int id, String designation) {
        this.id = id;
        this.designation = designation;
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
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }
   
   
   
    
}
