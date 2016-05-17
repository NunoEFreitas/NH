/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.dao;

import com.nh.model.Product;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nfreitas
 */
@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao{

    public Product findById(int id) {
        return getByKey(id);
    }

    public void saveProduct(Product product) {
        persist(product);
    }

    public void deleteProductById(int id) {
        Query query = getSession().createSQLQuery("delete from product where id = :id");
	query.setString("id", Integer.toString(id));
        query.executeUpdate();
    }

    public List<Product> findAllProducts() {
        Criteria criteria = createEntityCriteria();
        return (List<Product>) criteria.list();
    }

    public List<Product> findAllProductsByProductType(int productTypeId) {
        Criteria criteria = createEntityCriteria();
	criteria.add(Restrictions.eq("productType_id",productTypeId));
	return (List<Product>) criteria.list();
    }

    public List<Product> findAllProductsWithStock() {
        Criteria criteria = createEntityCriteria();
	criteria.add(Restrictions.gt("quantity",0));
	return (List<Product>) criteria.list();
    }

    public Product findByDesignation(String designation) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("designation", designation));
        return (Product) criteria.uniqueResult();
    }
    
}
