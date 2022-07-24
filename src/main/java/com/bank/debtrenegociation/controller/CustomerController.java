/**
 * 
 */
package com.bank.debtrenegociation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.debtrenegociation.model.Customer;
import com.bank.debtrenegociation.service.CustomerService;

/**
 * @author Alex
 *
 */
@RestController
@RequestMapping("/customer")
@ResponseBody
public class CustomerController {

	@Autowired
	private CustomerService service;

	@PostMapping
	public void save(@Valid @RequestBody Customer request) {
		service.save(request);
	}
	
	@GetMapping
	public List<Customer> find (String cpf) {
		return service.find(cpf);
	}
	
	@DeleteMapping
	public void delete (String cpf) {
		service.delete(cpf);
	}
	
}
