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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author hvsousa
 */
@Entity
@Table(name="users")
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @NotEmpty
//    @Pattern.List({
//    @Pattern(regexp = "(?=.*[0-9])", message = "Password must contain one digit."),
//    @Pattern(regexp = "(?=.*[a-z])", message = "Password must contain one lowercase letter."),
//    @Pattern(regexp = "(?=.*[a-z])", message = "Password must contain one lowercase letter."),
//    @Pattern(regexp = "(?=\\S+$)", message = "Password must contain no whitespace.")
//    })
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,20}")
    @Size(min=6,max=20)
    @Column(name="password")
    private String password;
    
    @NotEmpty
    @Size(min=3,max=100)
    @Column(name="name")
    private String name;
    
    @NotEmpty
    @Size(min=3,max=100)
    @Column(name="address")
    private String address;
    
    @NotNull
    @Min(200000000)
    @Max(999999999)
    @Column(name="telephone")
    private int telephone;

    @NotEmpty
    @Size(min=10, max=50)
    @Pattern(regexp="\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(.\\w{2,4})+")
    @Column(name="email")
    private String email;
    
    @NotNull
    @Min(000000000)
    @Max(999999999)
    @Column(name="nif")
    private int nif;
    
    @ManyToOne()
    @JoinColumn(name="userProfile_id")
    private UserProfile userProfile;


    public User() {
    }

    public User(int id, String password, String name, String address, int telephone, String email, int nif, UserProfile userProfile) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.nif = nif;
        this.userProfile = userProfile;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the telephone
     */
    public int getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the nif
     */
    public int getNif() {
        return nif;
    }

    /**
     * @param nif the nif to set
     */
    public void setNif(int nif) {
        this.nif = nif;
    }

    /**
     * @return the userProfile_id
     */
    public UserProfile getUserProfile() {
        return userProfile;
    }

    /**
     * @param userProfile_id the userProfile_id to set
     */
    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

         
}
