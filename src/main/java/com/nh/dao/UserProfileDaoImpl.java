/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.dao;

import com.nh.model.UserProfile;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hvsousa
 */
@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, UserProfile> implements UserProfileDao{

    public void addUserProfile(UserProfile up) {
        this.persist(up);
    }

    public UserProfile getUserProfileById(int id) {
        return this.getByKey(id);
    }

    public List<UserProfile> listAllUsersProfiles() {
        Criteria criteria = createEntityCriteria();
        return (List<UserProfile>) criteria.list();
    }

    public void deleteUserProfile(int id) {
        this.deleteById(id);
    }

  
    
}
