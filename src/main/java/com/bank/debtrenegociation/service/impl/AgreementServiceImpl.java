/**
 * 
 */
package com.bank.debtrenegociation.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.debtrenegociation.dto.AgreementProposalDTO;
import com.bank.debtrenegociation.enums.ProposalStatus;
import com.bank.debtrenegociation.mapper.Mapper;
import com.bank.debtrenegociation.model.AgreementProposal;
import com.bank.debtrenegociation.repository.AgreementProposalRepository;
import com.bank.debtrenegociation.service.AgreementService;
import com.bank.debtrenegociation.service.CustomerService;
import com.bank.debtrenegociation.service.OfferService;
import com.bank.debtrenegociation.specifications.AgreementSpecification;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Alex
 *
 */
@Service
@Slf4j

public class AgreementServiceImpl implements AgreementService {
	
	@Autowired private AgreementProposalRepository repository;
	@Autowired private CustomerService customerService;
	@Autowired private OfferService offerService;

	@Override
	public void propose(AgreementProposalDTO request) {
		AgreementProposal proposal = Mapper.Agreement.to(request);
		proposal.setCustomer(customerService.find(proposal.getCustomer().getDocument()).get(0));
		proposal.setOffer(offerService.find(proposal.getOffer().getId()));
		proposal.setStatus(ProposalStatus.PENDING);
		repository.save(proposal);
	}

	@Override
	public AgreementProposalDTO check(String document) {
		return Mapper.Agreement.from(find(document).orElse(null));
	}

	private Optional<AgreementProposal> find(String document) {
		return repository.findOne(AgreementSpecification.getByDocument(document));
	}

	@Override
	public void cancel(String document) {
		Optional<AgreementProposal> optional = find(document);
		optional.ifPresent(proposal -> {
			repository.delete(proposal);
		});
	}

}
