///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.nh.service;
//
//import com.nh.dao.SaleDao;
//import com.nh.model.Sale;
//import java.util.List;
//import javax.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author hvsousa
// */
//@Service("saleService")
//@Transactional
//public class SaleServiceImpl implements SaleService{
//    
//    @Autowired
//    private SaleDao saleDao;
//
//    public void addSale(Sale sale) {
//        this.saleDao.addSale(sale);
//    }
//
//    public Sale findSaleById(int id) {
//        return this.saleDao.findSaleById(id);
//    }
//
//    public List<Sale> getAllSales() {
//        return this.saleDao.getAllSales();
//    }
//
//    public void updateSale(Sale sale) {
//        this.saleDao.updateSale(sale);
//    }
//
//    public void deleteSale(int id) {
//        this.saleDao.deleteSale(id);
//    }
//    
//}
