/**
 * 
 */
package com.bank.debtrenegociation.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.bank.debtrenegociation.model.Customer;
import com.bank.debtrenegociation.repository.CustomerRepository;
import com.bank.debtrenegociation.service.CustomerService;
import com.bank.debtrenegociation.specifications.CustomerSpecification;

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
		log.info("[CustomerServiceImpl  - save] Starting...");
		repository.save(request);
		log.info("[CustomerServiceImpl  - save] Ending...");
	}

	@Override
	public List<Customer> find(String document) {
		log.info("[CustomerServiceImpl  - find] Starting...");
		List<Customer> customers;
		if (StringUtils.isEmpty(document)) {
			customers = repository.findAll();
		} else {
			customers = repository.findAll(CustomerSpecification.getByDocument(document));
		}
		log.info("[CustomerServiceImpl  - find] Ending...");
		return customers;
	}

	@Override
	public void delete(String document) {
		log.info("[CustomerServiceImpl  - delete] Starting...");
		List<Customer> customers = find(document);
		if (!CollectionUtils.isEmpty(customers)) {
			Customer customer = customers.get(0);
			repository.delete(customer);
			
		} else {
			log.info("[CustomerServiceImpl  - delete] No customer found...");
		}
		
		log.info("[CustomerServiceImpl  - delete] Ending...");
	}

}
