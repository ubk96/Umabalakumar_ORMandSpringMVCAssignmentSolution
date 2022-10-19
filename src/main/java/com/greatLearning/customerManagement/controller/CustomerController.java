package com.greatLearning.customerManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatLearning.customerManagement.entity.Customer;
import com.greatLearning.customerManagement.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {

		List<Customer> theCustomers = customerService.getAllCustomers();

		theModel.addAttribute("Customers", theCustomers);

		return "customer-list";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Customer theCustomer = new Customer();

		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int theId, Model theModel) {

		Customer theCustomer = customerService.getCustomerById(theId);

		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@PostMapping("/save")
	public String save(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {

		Customer theCustomer;

		if (id != 0) {

			theCustomer = customerService.getCustomerById(id);
			theCustomer.setFirstName(firstName);
			theCustomer.setLastName(lastName);
			theCustomer.setEmail(email);
		}

		else {

			theCustomer = new Customer();
			theCustomer.setFirstName(firstName);
			theCustomer.setLastName(lastName);
			theCustomer.setEmail(email);

		}
		customerService.save(theCustomer);

		return "redirect:/customer/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int theId) {

		customerService.deleteCustomerById(theId);

		return "redirect:/customer/list";
	}
}
