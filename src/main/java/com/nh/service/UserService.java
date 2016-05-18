/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.service;

import com.nh.model.User;
import java.util.List;

/**
 *
 * @author hvsousa
 */
public interface UserService {
    void saveUser(User user);
    User findUserById(int id);
    User findUserByNif(int nif);
    User findUserByEmail(String email);
    void updateUser(User user);
    List<User> listAllUsers();
    void deleteUser(int id);
    
}
