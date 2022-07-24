/**
 * 
 */
package com.bank.debtrenegociation.service;

import java.util.List;

import com.bank.debtrenegociation.model.Offer;

/**
 * @author Alex
 *
 */
public interface OfferService {

	void save(Offer request);
	List<Offer> find();
	void delete();
	
}
