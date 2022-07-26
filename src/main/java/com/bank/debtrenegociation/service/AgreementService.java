/**
 * 
 */
package com.bank.debtrenegociation.service;

import com.bank.debtrenegociation.dto.AgreementProposalDTO;

/**
 * @author Alex
 *
 */
public interface AgreementService {

	void propose(AgreementProposalDTO request);
	AgreementProposalDTO check(String document);
	void cancel(String document);

}
