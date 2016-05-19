/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.dao;

import com.nh.model.Sale;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hvsousa
 */
@Repository("saleDao")
public class SaleDaoImpl extends AbstractDao<Integer, Sale> implements SaleDao{

    public void addSale(Sale sale) {
        this.persist(sale);
    }

    public Sale findSaleById(int id) {
        return this.getByKey(id);
    }

    public void updateSale(Sale sale) {
        Sale entity = this.findSaleById(sale.getId());
	if(entity!=null){
            entity.setDate(sale.getDate());
            entity.setPriceTotal(sale.getPriceTotal());
            entity.setPaid(sale.isPaid());
            entity.setOrder(sale.getOrder());
            entity.setOrderProduct(sale.getOrderProduct());
            entity.setPaymentType(sale.getPaymentType());
	}
    }

    public void deleteSale(int id) {
        this.deleteById(id);
    }

    public List<Sale> getAllSales() {
        Criteria criteria = createEntityCriteria();
        return (List<Sale>) criteria.list();
    }
    
    
    
}
