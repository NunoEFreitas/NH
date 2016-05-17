/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.dao;

import com.nh.model.ProductType;
import java.util.List;

/**
 *
 * @author nfreitas
 */
public interface ProductTypeDao {
    
        ProductType findById(int id);

	void saveProduct(ProductType productType);
        
        void deleteProductTypeById(int id);
	
	List<ProductType> findAllProductTypes();
        
        ProductType findProductTypeByDesignation(String designation);
    
}
