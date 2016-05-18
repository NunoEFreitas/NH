/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.controller;

import com.nh.model.OrderStatus;
import com.nh.model.OrderType;
import com.nh.service.OrderStatusService;
import com.nh.service.OrderTypeService;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author nfreitas
 */
@Controller
@RequestMapping("/")
public class OrderController {

    @Autowired
    HttpSession session;
    
    @Autowired
    OrderStatusService oss;
    
    @Autowired
    OrderTypeService ots;
   
    @RequestMapping(value = {"/neworderstatus"}, method = RequestMethod.GET)
    public String newOrderStatus(ModelMap model,HttpSession session) {
        OrderStatus oStatus = new OrderStatus();
        model.addAttribute("oStatus", oStatus);
        model.addAttribute("edit", false);
	return "neworderstatus";
    }
        
    @RequestMapping(value = {"/neworderstatus"}, method = RequestMethod.POST)
    public String saveOrderStatus(@Valid OrderStatus oStatus,BindingResult result,ModelMap model,HttpSession session) {
        if (result.hasErrors()) {
            return "neworderstatus";
	}
        if(oss.findOrderStatusByDesignation(oStatus.getDesignation())!=null){
            model.addAttribute("error", "Order Status already registered with " + oStatus.getId() + " ID");
            return "neworderstatus";
        }
        oss.saveOrderStatus(oStatus);
	model.addAttribute("message", "Order Status" + oStatus.getDesignation() + " registered successfully");
        return "index";
    }
        
    @RequestMapping(value = { "/edit-{id}-orderstatus" }, method = RequestMethod.GET)
    public String editOrderStatus(@PathVariable int id, ModelMap model,HttpSession session) {
        OrderStatus oStatus = oss.findById(id);
        model.addAttribute("oStatus",oStatus);
	model.addAttribute("edit", true);
	return "neworderstatus";
    }
        
    @RequestMapping(value = { "/edit-{id}-orderstatus" }, method = RequestMethod.POST)
    public String updateOrderStatus(@Valid OrderStatus oStatus,BindingResult result,ModelMap model, @PathVariable int id,HttpSession session) {
        if (result.hasErrors()) {
            return "neworderstatus";
	}
        oss.updateOrderStatus(oStatus);
        model.addAttribute("message", "Order Status " + oStatus.getDesignation() + " updated successfully");
	return "redirect:/listorderstatus";
    }
        
    @RequestMapping(value = { "/delete-{id}-orderstatus" }, method = RequestMethod.GET)
    public String deleteOrderStatus(@PathVariable int id,HttpSession session) {
        oss.deleteOrderStatusById(id);
        return "redirect:/listorderstatus";
    }
        
    @RequestMapping(value = {"/listorderstatus"}, method = RequestMethod.GET)
    public String listOrderStatus(ModelMap model,HttpSession session) {
        List<OrderStatus> los = oss.findAllOrderStatus();
        model.addAttribute("los", los);
	return "listorderstatus";
    }
 
    @RequestMapping(value = {"/newordertype"}, method = RequestMethod.GET)
    public String newOrderType(ModelMap model,HttpSession session) {
        OrderType oType = new OrderType();
        model.addAttribute("oType", oType);
        model.addAttribute("edit", false);
	return "newordertype";
    }
        
    @RequestMapping(value = {"/newordertype"}, method = RequestMethod.POST)
    public String saveOrderType(@Valid OrderType oType,BindingResult result,ModelMap model,HttpSession session) {
        if (result.hasErrors()) {
            return "newordertype";
	}
        if(ots.findOrderTypeByDesignation(oType.getDesignation())!=null){
            model.addAttribute("error", "Order Type already registered with " + oType.getId() + " ID");
            return "newordertype";
        }
        ots.saveOrderType(oType);
	model.addAttribute("message", "Order Type" + oType.getDesignation() + " registered successfully");
        return "index";
    }
        
    @RequestMapping(value = { "/edit-{id}-ordertype" }, method = RequestMethod.GET)
    public String editOrderType(@PathVariable int id, ModelMap model,HttpSession session) {
        OrderType oType = ots.findById(id);
        model.addAttribute("oType",oType);
	model.addAttribute("edit", true);
	return "newordertype";
    }
        
    @RequestMapping(value = { "/edit-{id}-ordertype" }, method = RequestMethod.POST)
    public String updateOrderType(@Valid OrderType oType,BindingResult result,ModelMap model, @PathVariable int id,HttpSession session) {
        if (result.hasErrors()) {
            return "newordertype";
	}
        ots.updateOrderType(oType);
        model.addAttribute("message", "Order Type " + oType.getDesignation() + " updated successfully");
	return "redirect:/listordertypes";
    }
        
    @RequestMapping(value = { "/delete-{id}-ordertype" }, method = RequestMethod.GET)
    public String deleteOrderType(@PathVariable int id,HttpSession session) {
        ots.deleteOrderTypeById(id);
        return "redirect:/listordertypes";
    }
        
    @RequestMapping(value = {"/listordertypes"}, method = RequestMethod.GET)
    public String listOrderType(ModelMap model,HttpSession session) {
        List<OrderType> lot = ots.findAllOrderType();
        model.addAttribute("lot", lot);
	return "listordertypes";
    }

}
