package com.app.springdemo.controller;

import com.app.springdemo.dao.CustomerDAO;
import com.app.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {


	//need to inject the customer dao
	@Autowired
	private CustomerDAO customerDAO;


	@RequestMapping("/list")
	public String listCustomers(Model theModel) {

		//get customer from DAO
		List<Customer> theCustomers = customerDAO.getCustomers();
		//add customet to the model
		theModel.addAttribute("customers", theCustomers);
		return "list-customers";
	}
	
}


