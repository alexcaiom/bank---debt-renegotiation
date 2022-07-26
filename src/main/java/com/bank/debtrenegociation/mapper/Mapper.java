/**
 * 
 */
package com.bank.debtrenegociation.mapper;

import java.util.Objects;

import org.springframework.util.CollectionUtils;

import com.bank.debtrenegociation.dto.AgreementProposalDTO;
import com.bank.debtrenegociation.dto.CustomerDTO;
import com.bank.debtrenegociation.dto.OfferDTO;
import com.bank.debtrenegociation.model.AgreementProposal;

/**
 * @author Alex
 *
 */
public class Mapper {

	public static final class Agreement {
		public static AgreementProposal to(AgreementProposalDTO request) {
			AgreementProposal proposal = new AgreementProposal();
			proposal.setCustomer(Mapper.Customer.to(request.getCustomer()));
			proposal.setOffer(Mapper.Offer.to(request.getOffer()));
			proposal.setStatus(request.getStatus());
			return proposal;
		}

		public static AgreementProposalDTO from(AgreementProposal entity) {
			AgreementProposalDTO response = new AgreementProposalDTO();
			if (Objects.nonNull(entity)) {
				response.setCustomer(Mapper.Customer.from(entity.getCustomer()));
				response.setOffer(Mapper.Offer.from(entity.getOffer()));
				response.setStatus(entity.getStatus());
			}
			return response;
		}
	}
	
	public static final class Customer {
		public static com.bank.debtrenegociation.model.Customer to(CustomerDTO request) {
			com.bank.debtrenegociation.model.Customer customer = new com.bank.debtrenegociation.model.Customer();
			customer.setDocument(request.getDocument());
			customer.setId(request.getId());
			return customer;
		}

		public static CustomerDTO from(com.bank.debtrenegociation.model.Customer entity) {
			CustomerDTO response = new CustomerDTO();
			response.setDocument(entity.getDocument());
			response.setId(entity.getId());
			return response;
		}
	}
	
	public static final class Offer {
		public static com.bank.debtrenegociation.model.Offer to(OfferDTO request) {
			com.bank.debtrenegociation.model.Offer offer = new com.bank.debtrenegociation.model.Offer();
			offer.setDescription(request.getDescription());
			offer.setEnd(request.getEnd());
			offer.setStart(request.getStart());
			offer.setId(request.getId());
			offer.setInstallments(request.getInstallments());
			offer.setValue(request.getValue());
			if (!CollectionUtils.isEmpty(offer.getTargets())) {
				offer.setTargets(request.getTargets().stream().map( target -> {
					return Mapper.Customer.to(target);
				}).toList());
			}
			return offer;
		}

		public static OfferDTO from(com.bank.debtrenegociation.model.Offer entity) {
			OfferDTO offer = new OfferDTO();
			offer.setDescription(entity.getDescription());
			offer.setEnd(entity.getEnd());
			offer.setStart(entity.getStart());
			offer.setId(entity.getId());
			offer.setInstallments(entity.getInstallments());
			offer.setValue(entity.getValue());
			offer.setTargets(entity.getTargets().stream().map( target -> {
				return Mapper.Customer.from(target);
			}).toList());
			return offer;
		}
	}

}
