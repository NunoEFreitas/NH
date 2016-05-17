/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.service;


import com.nh.dao.UserProfileDao;
import com.nh.model.UserProfile;
import java.util.List;
import org.hibernate.usertype.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hvsousa
 */
@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService{
    
    @Autowired
     private UserProfileDao userProfile;

    public void saveUserProfile(UserProfile userType) {
        this.userProfile.addUserProfile(userType);
    }

    public UserProfile findUserProfile(int id) {
        return this.userProfile.getUserProfileById(id);
    }

    public void updateUserProfile(UserProfile userType) {
        UserProfile entity = userProfile.getUserProfileById(userType.getId());
        if(entity!=null){
            entity.setDesignation(userType.getDesignation());
        }
    }

    public List<UserProfile> findAllUsersProfiles() {
        return this.userProfile.listAllUsersProfiles();
    }

    public void deleteUserProfile(int id) {
        this.userProfile.deleteUserProfile(id);
    }

    
    
    
}
