/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.service;

import com.nh.dao.ProductTypeDao;
import com.nh.model.ProductType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nfreitas
 */
@Service("productTypeService")
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService{
    
    @Autowired
    private ProductTypeDao dao;

    public ProductType findById(int id) {
        return dao.findById(id);
    }

    public void saveProductType(ProductType productType) {
        dao.saveProductType(productType);
    }

    public void updateProductType(ProductType productType) {
        ProductType entity = dao.findById(productType.getId());
        if(entity!=null){
            entity.setDesignation(productType.getDesignation());
        }
    }

    public void deleteProductTypeById(int id) {
        dao.deleteProductTypeById(id);
    }

    public List<ProductType> findAllProductTypes() {
        return dao.findAllProductTypes();
    }

    public ProductType findProductTypeByDesignation(String designation) {
        return dao.findProductTypeByDesignation(designation);
    }
    
}
