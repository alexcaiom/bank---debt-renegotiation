/**
 * 
 */
package com.bank.debtrenegociation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.debtrenegociation.model.Offer;
import com.bank.debtrenegociation.service.OfferService;

/**
 * @author Alex
 *
 */
@RestController
@RequestMapping("/offer")
@ResponseBody
public class OfferController {
	
	@Autowired
	private OfferService service;

	@PostMapping
	public void save(Offer request) {
		service.save(request);
	}
	
	@GetMapping
	public List<Offer> find () {
		return service.find();
	}
	
	@DeleteMapping
	public void delete () {
		service.delete();
	}
	
}
