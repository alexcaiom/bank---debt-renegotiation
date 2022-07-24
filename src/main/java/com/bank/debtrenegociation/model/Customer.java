/**
 * 
 */
package com.bank.debtrenegociation.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Alex
 *
 */
@Entity
@Table(name = "TB_CUSTOMER", schema = "DR")
public class Customer {
	
	@Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CUSTOMER")
//    @SequenceGenerator(sequenceName = "SEQ_CUSTOMER", allocationSize = 1, name = "SEQ_CUSTOMER")

    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String cpf;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "TB_CUSTOMER_OFFERS",
			joinColumns =  @JoinColumn(referencedColumnName = "id") ,
			inverseJoinColumns = @JoinColumn(referencedColumnName = "id")
			)
	private Set<Offer> offers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Set<Offer> getOffers() {
		return offers;
	}

	public void setOffers(Set<Offer> offers) {
		this.offers = offers;
	}

}
