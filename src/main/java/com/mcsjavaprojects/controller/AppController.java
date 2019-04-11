package com.mcsjavaprojects.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mcsjavaprojects.model.Customer;
import com.mcsjavaprojects.service.CustomerService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	CustomerService service;
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String homePage() {		
		return "home";
	}

	/*
	 * Método para listar todos los clientes existentes.
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listCustomers(ModelMap model) {
		List<Customer> customers = service.findAllCustomers();
		model.addAttribute("customers", customers);
		return "customerslist";
	}

	/*
	 * Método para añadir un nuevo cliente.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newCustomer(ModelMap model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		model.addAttribute("edit", false);
		return "registration";
	}

	/*	 
	 * Método que es llamado al enviar el formulario "registration" y se encargará de la 
	 * solicitud POST para guardar un cliente en la base de datos. También valida los datos 
	 * introducidos
	 * 
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveCustomer(@Valid Customer customer, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		
		if(!service.isCustomerEmailUnique(customer.getId(), customer.getEmail())){
			FieldError emailError =new FieldError("customer","email",messageSource.getMessage("non.unique.email", new String[]{customer.getEmail()}, Locale.getDefault()));
		    result.addError(emailError);
			return "registration";
		}
		
		service.saveCustomer(customer);

		model.addAttribute("success", "Customer " + customer.getName() + " registered successfully");
		return "success";
	}


	/*
	 * Método para actualizar a un cliente existente en la base de datos.
	 */
	@RequestMapping(value = { "/edit-{email}-customer" }, method = RequestMethod.GET)
	public String editCustomer(@PathVariable String email, ModelMap model) {
		Customer customer = service.findCustomerByEmail(email);
		model.addAttribute("customer", customer);
		model.addAttribute("edit", true);
		return "registration";
	}	
	 
	@RequestMapping(value = { "/edit-{email}-customer" }, method = RequestMethod.POST)
	public String updateCustomer(@Valid Customer customer, BindingResult result,
			ModelMap model, @PathVariable String email) {

		if (result.hasErrors()) {
			return "registration";
		}

		if(!service.isCustomerEmailUnique(customer.getId(), customer.getEmail())){
			FieldError emailError =new FieldError("customer","email",messageSource.getMessage("non.unique.email", new String[]{customer.getEmail()}, Locale.getDefault()));
		    result.addError(emailError);
			return "registration";
		}

		service.updateCustomer(customer);

		model.addAttribute("success", "Customer " + customer.getName()	+ " updated successfully");
		return "success";
	}

	
	/*
	 * Método que borra un cliente por su email.
	 */
	@RequestMapping(value = { "/delete-{email}-customer" }, method = RequestMethod.GET)
	public String deleteCustomer(@PathVariable String email) {
		service.deleteCustomerByEmail(email);
		return "redirect:/list";
	}

}
