/**
 * 
 */
package com.bank.debtrenegociation.service;

import java.util.List;

import com.bank.debtrenegociation.model.Customer;

/**
 * @author Alex
 *
 */
public interface CustomerService {

	void save(Customer request);
	List<Customer> find(String cpf);
	void delete(String cpf);
	
}
