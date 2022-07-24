/**
 * 
 */
package com.bank.debtrenegociation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.bank.debtrenegociation.model.Customer;
import com.bank.debtrenegociation.model.Offer;
import com.bank.debtrenegociation.repository.OfferRepository;
import com.bank.debtrenegociation.service.OfferService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Alex
 *
 */
@Service
@Slf4j
public class OfferServiceImpl implements OfferService {

	@Autowired private OfferRepository repository;
	@Autowired private CustomerServiceImpl customerService;
	
	@Override
	public void save(Offer request) {
		log.info("[OfferServiceImpl  - save] Starting...");
		if (!CollectionUtils.isEmpty(request.getTargets())) {
			for (Customer customer : request.getTargets()) {
				List<Customer> customers = customerService.find(customer.getDocument());
				request.setTargets(customers);
			}
		}
		repository.save(request);
		log.info("[OfferServiceImpl  - save] Ending...");
	}

	@Override
	public List<Offer> find() {
		log.info("[OfferServiceImpl  - find] Starting...");
		List<Offer> offers = repository.findAll();
		log.info("[OfferServiceImpl  - find] Ending...");
		return offers;
	}

	@Override
	public void delete() {
		log.info("[OfferServiceImpl  - delete] Starting...");
		List<Offer> offers = find();
		for (Offer offer : offers) {
			repository.delete(offer);
		}
		log.info("[OfferServiceImpl  - delete] Ending...");
	}

}
