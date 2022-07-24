/**
 * 
 */
package com.bank.debtrenegociation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.bank.debtrenegociation.model.Offer;

/**
 * @author Alex
 *
 */
public interface OfferRepository extends JpaRepository<Offer, Long>, JpaSpecificationExecutor<Offer> {

}
