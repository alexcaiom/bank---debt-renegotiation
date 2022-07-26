/**
 * 
 */
package com.bank.debtrenegociation.service;

import java.util.List;

import com.bank.debtrenegociation.dto.OfferDTO;
import com.bank.debtrenegociation.model.Offer;

/**
 * @author Alex
 *
 */
public interface OfferService {

	void save(OfferDTO request);
	List<OfferDTO> find();
	Offer find(Long id);
	void delete(Long id);
	
}
