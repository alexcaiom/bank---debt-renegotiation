/**
 * 
 */
package com.bank.debtrenegociation.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Alex
 *
 */
@Entity
@Table(name = "TB_OFFER", schema = "DR")
public class Offer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8071136436863226025L;
	@Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_OFFER")
//    @SequenceGenerator(sequenceName = "SEQ_OFFER", allocationSize = 1, name = "SEQ_OFFER")

    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String description;
	private BigDecimal value;
	private Integer installments;
	@OneToMany
	private List<Customer> targets;
	private LocalDateTime start;
	private LocalDateTime end;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public Integer getInstallments() {
		return installments;
	}
	public void setInstallments(Integer installments) {
		this.installments = installments;
	}
	public List<Customer> getTargets() {
		return targets;
	}
	public void setTargets(List<Customer> targets) {
		this.targets = targets;
	}
	public LocalDateTime getStart() {
		return start;
	}
	public void setStart(LocalDateTime start) {
		this.start = start;
	}
	public LocalDateTime getEnd() {
		return end;
	}
	public void setEnd(LocalDateTime end) {
		this.end = end;
	}
	
}
