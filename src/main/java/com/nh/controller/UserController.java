/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.controller;

import com.nh.model.User;
import com.nh.service.UserProfileService;
import com.nh.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author hvsousa
 */

@Controller
@RequestMapping("/")
public class UserController {
 
    @Autowired
    UserService userService;
    
    @Autowired
    UserProfileService userProfileService;
    
    @RequestMapping(value = {"/listAllUsers"}, method = RequestMethod.GET)
    public String listAllUsersPage(ModelMap map){
        List<User> allUsers = this.userService.listAllUsers();
        map.addAttribute("allUsers", allUsers);
    return "/listAllUsers";
    }
    
    
}
