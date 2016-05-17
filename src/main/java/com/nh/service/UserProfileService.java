/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.service;

import com.nh.model.UserProfile;
import java.util.List;


/**
 *
 * @author hvsousa
 */
public interface UserProfileService {
    void saveUserProfile(UserProfile userType);
    UserProfile findUserProfile(int id);
    void updateUserProfile(UserProfile userType);
    List<UserProfile> findAllUsersProfiles();
    void deleteUserProfile(int id);
    
}
