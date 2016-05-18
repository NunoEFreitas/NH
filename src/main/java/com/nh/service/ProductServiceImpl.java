/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.service;

import com.nh.dao.ProductDao;
import com.nh.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nfreitas
 */
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    private ProductDao dao;

    public Product findById(int id) {
        return dao.findById(id);
    }

    public void saveProduct(Product product) {
        dao.saveProduct(product);
    }

    public void updateProduct(Product product) {
        Product entity = dao.findById(product.getId());
	if(entity!=null){
            entity.setDesignation(product.getDesignation());
            entity.setPrice(product.getPrice());
            entity.setProductType(product.getProductType());
            entity.setQuantity(product.getQuantity());
	}
    }

    public void deleteProductById(int id) {
        dao.deleteProductById(id);
    }

    public List<Product> findAllProducts() {
        return dao.findAllProducts();
    }

    public List<Product> findAllProductsByProductType(int productTypeId) {
        return dao.findAllProductsByProductType(productTypeId);
    }

    public List<Product> findAllProductsWithStock() {
        return dao.findAllProductsWithStock();
    }

    public Product findByDesignation(String designation) {
        return dao.findByDesignation(designation);
    }
    
}
