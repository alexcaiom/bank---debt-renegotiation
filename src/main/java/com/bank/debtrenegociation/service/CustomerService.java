/**
 * 
 */
package com.bank.debtrenegociation.service;

import com.bank.debtrenegociation.model.Customer;

/**
 * @author Alex
 *
 */
public interface CustomerService {

	void save(Customer request);
	Customer find(String cpf);
	void delete(String cpf);
	
}
