package com.nh.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/")
public class AppController {

        @Autowired
        HttpSession session;

        @RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String index(HttpSession session,ModelMap model) {
		return "index";
	}
        
        @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
	public String indexCall(HttpSession session,ModelMap model) {
		return "index";
	}
        
        
}
