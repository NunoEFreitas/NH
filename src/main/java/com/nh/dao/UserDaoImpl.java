/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.dao;

import com.nh.model.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hvsousa
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{

    public void registerUser(User user) {
        this.persist(user);
    }

    public User findUserById(int id) {
       return this.getByKey(id);
    }

    public User findUserByEmail(String email) {
      Criteria criteria = createEntityCriteria();
      criteria.add(Restrictions.eq("email", email));
      return (User) criteria.uniqueResult();
    }

    public User findUserByNif(long nif) {
         Criteria criteria = createEntityCriteria();
         criteria.add(Restrictions.eq("nif", nif));
         return (User) criteria.uniqueResult(); 
    }

    public List<User> listUsers() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }

    public void updateUser(User user) {
        User entity = this.findUserById(user.getId());
	if(entity!=null){
            entity.setAddress(user.getAddress());
            entity.setEmail(user.getEmail());
            entity.setName(user.getName());
            entity.setNif(user.getNif());
            entity.setPassword(user.getPassword());
            entity.setTelephone(user.getTelephone());
            entity.setUserProfile_id(user.getUserProfile_id());
	}
    }

    public void deleteUser(int id) {
        this.deleteById(id);
    }
    
}
