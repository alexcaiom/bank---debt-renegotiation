/**
 * 
 */
package com.bank.debtrenegociation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.debtrenegociation.dto.AgreementProposalDTO;
import com.bank.debtrenegociation.service.AgreementService;

/**
 * @author Alex
 *
 */
@RestController
@RequestMapping("/agreement")
@ResponseBody
public class AgreementController {
	
	@Autowired
	private AgreementService service;
	
	@PostMapping
	public void propose (@Valid @RequestBody AgreementProposalDTO request) {
		service.propose(request);
	}
	
	@GetMapping
	public AgreementProposalDTO check (@Valid String document) {
		return service.check(document);
	}
	
	@DeleteMapping
	public void cancel (@Valid String document) {
		service.cancel(document);
	}

}
