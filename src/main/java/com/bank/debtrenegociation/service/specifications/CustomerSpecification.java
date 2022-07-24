/**
 * 
 */
package com.bank.debtrenegociation.service.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.bank.debtrenegociation.model.Customer;

/**
 * @author Alex
 *
 */
public class CustomerSpecification {

	@SuppressWarnings("serial")
	public static Specification<Customer> getByDocument(String document) {
		return new Specification<Customer>() {
			@Override
			public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.equal(root.get("document"), document);
			}
		};
	}

	
	
}
