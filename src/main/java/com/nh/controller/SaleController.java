/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.controller;

import com.nh.model.Sale;
import com.nh.service.OrderService;
import com.nh.service.PaymentTypeService;
import com.nh.service.ProductService;
import com.nh.service.SaleService;
import com.nh.service.UserProfileService;
import com.nh.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author hvsousa
 */
@Controller
@RequestMapping("/")
public class SaleController {
    @Autowired
    UserService userService;
      
    @Autowired
    SaleService saleService;
    
    @Autowired
    PaymentTypeService paymentTypeService;
    
    @Autowired
    OrderService orderService;
    
    @Autowired
    ProductService productService;
    
    @RequestMapping(value = {"/listAllSales"}, method = RequestMethod.GET)
    public String listAllUsersPage(ModelMap map){
        List<Sale> allSales = this.saleService.getAllSales();
        map.addAttribute("allSales", allSales);
    return "/listAllSales";
    }
}
