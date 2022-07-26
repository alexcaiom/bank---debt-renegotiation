/**
 * 
 */
package com.bank.debtrenegociation.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.bank.debtrenegociation.dto.CustomerDTO;
import com.bank.debtrenegociation.dto.OfferDTO;
import com.bank.debtrenegociation.mapper.Mapper;
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
	public void save(OfferDTO request) {
		log.info("[OfferServiceImpl  - save] Starting...");
		Offer offer = Mapper.Offer.to(request);
		List<Customer> targets = new ArrayList<>();
		if (!CollectionUtils.isEmpty(request.getTargets())) {
			for (CustomerDTO customer : request.getTargets()) {
				List<Customer> customers = customerService.find(customer.getDocument());
				if (!CollectionUtils.isEmpty(customers)) {
					Customer entity = customers.get(0);
					targets.add(entity);
				}
			}
		}
		offer.setTargets(targets);
		repository.save(offer);
		log.info("[OfferServiceImpl  - save] Ending...");
	}

	@Override
	public List<OfferDTO> find(
//			String start, String end
			) {
		log.info("[OfferServiceImpl  - find] Starting...");
		List<Offer> offers;
//		if (!StringUtils.isEmpty(start) && !StringUtils.isEmpty(end)) {
//			offers = repository.findAll(OfferSpecification.getByDates(start, end));
//		} else {
			offers = repository.findAll();
//		}
		List<OfferDTO> response = new ArrayList<>();
		if (!CollectionUtils.isEmpty(offers)) {
			offers.forEach(entity -> {
				response.add(Mapper.Offer.from(entity));
			});
		}
		log.info("[OfferServiceImpl  - find] Ending...");
		return response;
	}

	@Override
	public void delete(Long id) {
		log.info("[OfferServiceImpl  - delete] Starting...");
		Optional<Offer> offer = repository.findById(id);
		if (offer.isPresent()) {
			repository.delete(offer.get());
		} else {
			log.info("[OfferServiceImpl  - delete] No offer found for id {}...", id);
		}
		log.info("[OfferServiceImpl  - delete] Ending...");
	}

	@Override
	public Offer find(Long id) {
		return repository.findById(id).orElse(null);
	}

}
