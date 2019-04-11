package com.mcsjavaprojects.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mcsjavaprojects.model.Customer;
import com.mcsjavaprojects.service.CustomerService;

@Controller
@RequestMapping("/")
public class ReportController {
	
	@Autowired
	CustomerService service;
	
	@RequestMapping(value = {"/customersReport"}, method = RequestMethod.GET)
    public String generateReport(ModelMap model) {
		Customer user = new Customer();
        model.addAttribute("customer", user);     
        model.addAttribute("edit", false);       
        return "customersReport";    }    
	
	
	@RequestMapping(value = "/customersReport/report/{fmt}") 	        
    public String report(@PathVariable("fmt") String format, Model model ) {
				
		        model.addAttribute("format", format);
		        model.addAttribute("datasource", service.findAllCustomers());
		        return "customers_report";
    }    

}
