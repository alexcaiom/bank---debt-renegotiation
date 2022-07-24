/**
 * 
 */
package com.bank.debtrenegociation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * @author Alex
 *
 */
@Entity
@Table(name = "TB_CUSTOMER", schema = "DR"
,uniqueConstraints = @UniqueConstraint(name="unique_document", columnNames = "document")
)
public class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8728474519570579703L;
	
	@Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CUSTOMER")
//    @SequenceGenerator(sequenceName = "SEQ_CUSTOMER", allocationSize = 1, name = "SEQ_CUSTOMER")

    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	@Column(length = 14, nullable = false)
	private String document;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

}
