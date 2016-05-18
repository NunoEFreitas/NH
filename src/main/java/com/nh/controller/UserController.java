/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.controller;

import com.nh.model.User;
import com.nh.model.UserProfile;
import com.nh.service.UserProfileService;
import com.nh.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = {"/delete-{id}-user"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id){//identifica o id que se esta a espera do link
     this.userService.deleteUser(id);
    return "redirect:/listAllUsers";
    }
    
    //uplist user
    @RequestMapping(value = {"/newUser"}, method = RequestMethod.GET)
    public String newUser(ModelMap model){
           User user = new User();
                List<UserProfile> uplist = userProfileService.findAllUsersProfiles();
                model.addAttribute("uplist",uplist);
                model.addAttribute("user", user);
                model.addAttribute("edit", false);
		return "newUser";
    }
    
    
    
    @RequestMapping(value = {"/newUser"}, method = RequestMethod.POST)
	public String saveUser(@Valid User user,BindingResult result,ModelMap model) {            
                if (result.hasErrors()) {
                        List<UserProfile> uplist = userProfileService.findAllUsersProfiles();
                        model.addAttribute("uplist",uplist);
                        model.addAttribute("error", "erro no 1"+model.toString());
			return "newUser";
		}
                
               //VALIDATE IF USER EXIST
                if(userService.findUserByNif(user.getNif())!=null || userService.findUserByEmail(user.getEmail())!=null){
                    List<UserProfile> uplist = userProfileService.findAllUsersProfiles();
                    model.addAttribute("uplist",uplist);
                    model.addAttribute("error", "User email ou nif already registered");
                    return "newUser";
                }

                this.userService.saveUser(user);
		return "redirect:listAllUsers";
	}
        
        
        @RequestMapping(value = { "/edit-{id}-user" }, method = RequestMethod.GET)
	public String editUser(@PathVariable int id, ModelMap model) {
                User user = userService.findUserById(id);
                List<UserProfile> uplist = userProfileService.findAllUsersProfiles();
                model.addAttribute("uplist",uplist);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		return "newUser";
	}
        
        
        // edit works, but user always have to select a profile, issue to be solved
        @RequestMapping(value = { "/edit-{id}-user" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user,BindingResult result,ModelMap model, @PathVariable int id) {
                if (result.hasErrors()) {
                        List<UserProfile> uplist = userProfileService.findAllUsersProfiles();
                        model.addAttribute("uplist",uplist);
			return "newUser";
		}
                userService.updateUser(user);
                model.addAttribute("message", "User " + user.getName() + " updated successfully");
		return "redirect:listAllUsers"; 
	}
}
