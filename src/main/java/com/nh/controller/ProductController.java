/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nh.controller;

import com.nh.model.Product;
import com.nh.model.ProductType;
import com.nh.service.ProductService;
import com.nh.service.ProductTypeService;
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

// TODO filtrar produtos por tipo
@Controller
@RequestMapping("/")
public class ProductController {
    
    @Autowired
    ProductService pService;
    
    @Autowired
    ProductTypeService ptService;
    
    @Autowired
    HttpSession session;
    
    @RequestMapping(value = {"/newproduct"}, method = RequestMethod.GET)
    public String newProduct(ModelMap model,HttpSession session) {
        Product product = new Product();
        List<ProductType> pType = ptService.findAllProductTypes();
        model.addAttribute("product", product);
        model.addAttribute("pType", pType);
        model.addAttribute("edit", false);
	return "newproduct";
    }
        
    @RequestMapping(value = {"/newproduct"}, method = RequestMethod.POST)
    public String saveProduct(@Valid Product product,BindingResult result,ModelMap model,HttpSession session) {
        if (result.hasErrors()) {
            return "newproduct";
	}
        if(pService.findByDesignation(product.getDesignation())!=null){
            model.addAttribute("error", "Product already registered with " + product.getId() + " ID");
            return "newproduct";
        }
        pService.saveProduct(product);
	model.addAttribute("message", "Product " + product.getDesignation() + " registered successfully");
        return "/";
    }
        
    @RequestMapping(value = { "/edit-{id}-product" }, method = RequestMethod.GET)
    public String editProduct(@PathVariable int id, ModelMap model,HttpSession session) {
        Product product = pService.findById(id);
	model.addAttribute("product", product);
	model.addAttribute("edit", true);
	return "newproduct";
    }
        
    @RequestMapping(value = { "/edit-{id}-product" }, method = RequestMethod.POST)
    public String updateProduct(@Valid Product product,BindingResult result,ModelMap model, @PathVariable int id,HttpSession session) {
        if (result.hasErrors()) {
            return "redirect:/newproduct";
	}
        pService.updateProduct(product);
        model.addAttribute("message", "Material " + product.getDesignation() + " updated successfully");
	return "listproducts";
    }
        
    @RequestMapping(value = { "/delete-{id}-product" }, method = RequestMethod.GET)
    public String deleteProduct(@PathVariable int id,HttpSession session) {
        pService.deleteProductById(id);
        return "redirect:/listproducts";
    }
        
    @RequestMapping(value = {"/listproducts"}, method = RequestMethod.GET)
    public String listProducts(ModelMap model,HttpSession session) {
        List<Product> lp = pService.findAllProducts();
        model.addAttribute("lp", lp);
	return "listproducts";
    }
    
    @RequestMapping(value = {"/newproducttype"}, method = RequestMethod.GET)
    public String newProductType(ModelMap model,HttpSession session) {
        ProductType pType = new ProductType();
        model.addAttribute("pType", pType);
        model.addAttribute("edit", false);
	return "newproducttype";
    }
        
    @RequestMapping(value = {"/newproducttype"}, method = RequestMethod.POST)
    public String saveProductType(@Valid ProductType ptype,BindingResult result,ModelMap model,HttpSession session) {
        if (result.hasErrors()) {
            return "newproducttype";
	}
        if(ptService.findProductTypeByDesignation(ptype.getDesignation())!=null){
            model.addAttribute("error", "Product Type already registered with " + ptype.getId() + " ID");
            return "newproducttype";
        }
        ptService.saveProduct(ptype);
	model.addAttribute("message", "Product Type" + ptype.getDesignation() + " registered successfully");
        return "/";
    }
        
    @RequestMapping(value = { "/edit-{id}-producttype" }, method = RequestMethod.GET)
    public String editProductType(@PathVariable int id, ModelMap model,HttpSession session) {
        ProductType pType = ptService.findById(id);
        model.addAttribute("pType",pType);
	model.addAttribute("edit", true);
	return "newproducttype";
    }
        
    @RequestMapping(value = { "/edit-{id}-producttype" }, method = RequestMethod.POST)
    public String updateProductType(@Valid ProductType pType,BindingResult result,ModelMap model, @PathVariable int id,HttpSession session) {
        if (result.hasErrors()) {
            return "newproducttype";
	}
        ptService.updateProductType(pType);
        model.addAttribute("message", "Material " + pType.getDesignation() + " updated successfully");
	return "listproducttypes";
    }
        
    @RequestMapping(value = { "/delete-{id}-producttype" }, method = RequestMethod.GET)
    public String deleteProductType(@PathVariable int id,HttpSession session) {
        ptService.deleteProductTypeById(id);
        return "redirect:/listproducttypes";
    }
        
    @RequestMapping(value = {"/listproducttypes"}, method = RequestMethod.GET)
    public String listProductTypes(ModelMap model,HttpSession session) {
        List<ProductType> lpt = ptService.findAllProductTypes();
        model.addAttribute("lpt", lpt);
	return "listproducttypes";
    }
    
}
