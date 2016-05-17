/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.dao;

import com.nh.model.Product;
import com.nh.model.ProductType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nfreitas
 */
@Repository("productTypeDao")
public class ProductTypeDaoImpl extends AbstractDao<Integer, ProductType> implements ProductTypeDao{

    public ProductType findById(int id) {
        return getByKey(id);
    }

    public void saveProduct(ProductType productType) {
         persist(productType);
    }

    public void deleteProductTypeById(int id) {
        Query query = getSession().createSQLQuery("delete from productType where id = :id");
	query.setString("id", Integer.toString(id));
        query.executeUpdate();
    }

    public List<ProductType> findAllProductTypes() {
        Criteria criteria = createEntityCriteria();
        return (List<ProductType>) criteria.list();
    }

    public ProductType findProductTypeByDesignation(String designation) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("designation", designation));
        return (ProductType) criteria.uniqueResult();
    }
    
}
