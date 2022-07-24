/**
 * 
 */
package com.bank.debtrenegociation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.debtrenegociation.model.Customer;
import com.bank.debtrenegociation.repository.CustomerRepository;
import com.bank.debtrenegociation.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Alex
 *
 */
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	@Override
	public void save(Customer request) {
		repository.save(request);
	}

	@Override
	public List<Customer> find() {
		List<Customer> customers = repository.findAll();
		return customers;
	}

	@Override
	public void delete() {
		List<Customer> customers = find();
		repository.deleteAll(customers);
	}

}
