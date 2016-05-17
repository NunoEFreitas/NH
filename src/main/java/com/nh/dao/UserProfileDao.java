/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.dao;

import com.nh.model.UserProfile;
import java.util.List;

/**
 *
 * @author hvsousa
 */
public interface UserProfileDao {
    
    void addUserProfile(UserProfile up);
    UserProfile getUserProfileById(int id);
    List<UserProfile> listAllUsersProfiles();
    void deleteUserProfile(int id);
}
