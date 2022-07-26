/**
 * 
 */
package com.bank.debtrenegociation.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Customer find(String document) {
		log.info("[CustomerServiceImpl  - find] Starting...");
		Customer customers = repository.findOne(CustomerSpecification.getByDocument(document)).orElse(null);
		log.info("[CustomerServiceImpl  - find] Ending...");
		return customers;
	}

	@Override
	public void delete(String document) {
		log.info("[CustomerServiceImpl  - delete] Starting...");
		Customer customer = find(document);
		if (Objects.nonNull(customer)) {
			repository.delete(customer);
		} else {
			log.info("[CustomerServiceImpl  - delete] No customer found...");
		}
		
		log.info("[CustomerServiceImpl  - delete] Ending...");
	}

}
