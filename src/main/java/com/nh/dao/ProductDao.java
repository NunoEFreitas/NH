/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.dao;

import com.nh.model.Product;
import java.util.List;

/**
 *
 * @author nfreitas
 */
public interface ProductDao {
    
        Product findById(int id);

	void saveProduct(Product product);
        
        void deleteProductById(int id);
	
	List<Product> findAllProducts();

        List<Product> findAllProductsByProductType(int productTypeId);
        
        List<Product> findAllProductsWithStock();
        
        Product findByDesignation(String designation);
    
}
