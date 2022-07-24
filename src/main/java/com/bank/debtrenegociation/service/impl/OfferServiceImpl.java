/**
 * 
 */
package com.bank.debtrenegociation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Autowired
	private OfferRepository repository;
	
	@Override
	public void save(Offer request) {
		repository.save(request);
	}

	@Override
	public List<Offer> find() {
		List<Offer> offers = repository.findAll();
		return offers;
	}

	@Override
	public void delete() {
		List<Offer> offers = find();
		for (Offer offer : offers) {
			repository.delete(offer);
		}
	}

}
