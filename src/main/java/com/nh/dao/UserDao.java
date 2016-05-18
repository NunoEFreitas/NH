/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.dao;

import com.nh.model.User;
import java.util.List;

/**
 *
 * @author hvsousa
 */
public interface UserDao {
    
    void registerUser(User user);
    User findUserById(int id);
    User findUserByEmail(String email);
    User findUserByNif(int nif);
    List<User> listUsers();
    void updateUser(User user);
    void deleteUser(int id);
    
    
}
