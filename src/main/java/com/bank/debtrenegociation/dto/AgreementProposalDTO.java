/**
 * 
 */
package com.bank.debtrenegociation.dto;

import java.io.Serializable;

import com.bank.debtrenegociation.enums.ProposalStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alex
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgreementProposalDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9058712477925683667L;

	private CustomerDTO customer;
	private OfferDTO offer;
	private ProposalStatus status;
	
}
