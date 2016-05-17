/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.service;

import com.nh.dao.UserDao;
import com.nh.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hvsousa
 */
@Service("userService")
public class UserServiceImpl  implements  UserService{
    
    @Autowired
   private UserDao user;

    public void saveUser(User user) {
       this.user.registerUser(user);
    }

    public User findUserById(int id) {
       return this.user.findUserById(id);
    }

    public User findUserByNif(long nif) {
        return this.user.findUserByNif(nif);
    }

    public User findUserByEmail(String email) {
        return this.user.findUserByEmail(email);
    }

    public void updateUser(User user) {
        this.user.updateUser(user);
    }

    public List<User> listAllUsers() {
        return this.user.listUsers();
    }

    public void deleteUser(int id) {
       this.user.deleteUser(id);
    }
    
}
