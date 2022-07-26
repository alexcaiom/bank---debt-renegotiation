/**
 * 
 */
package com.bank.debtrenegociation.specifications;

import java.time.LocalDateTime;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.bank.debtrenegociation.mapper.Mapper.Offer;
import com.bank.debtrenegociation.model.AgreementProposal;

/**
 * @author Alex
 *
 */
public class OfferSpecification {

	public static Specification<Offer> getByStartDate(LocalDateTime start) {
		return new Specification<Offer>() {
			@Override
			public Predicate toPredicate(Root<Offer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.equal(root.get("start"), start);
			}
		};
	}
	
	public static Specification<Offer> getByEndDate(String end) {
		return new Specification<Offer>() {
			
			@Override
			public Predicate toPredicate(Root<Offer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.equal(root.get("end"), end);
			}
		};
	}
	
//	public static Specification<Offer> getByDates(String start) {
//		return new Specification<Offer>() {
//			
//			@Override
//			public Predicate toPredicate(Root<Offer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//				return criteriaBuilder.;
//			}
//		};
//	}
//	
//	public static Specification<Offer> getByDates(String start, String end) {
//		return new Specification<Offer>() {
//			
//			@Override
//			public Predicate toPredicate(Root<Offer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//				return root.;
//			}
//		};
//	}

}
