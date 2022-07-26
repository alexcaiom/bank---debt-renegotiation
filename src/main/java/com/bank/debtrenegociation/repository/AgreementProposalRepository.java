/**
 * 
 */
package com.bank.debtrenegociation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.bank.debtrenegociation.model.AgreementProposal;

/**
 * @author Alex
 *
 */
public interface AgreementProposalRepository extends JpaRepository<AgreementProposal, Long>, JpaSpecificationExecutor<AgreementProposal> {

}
