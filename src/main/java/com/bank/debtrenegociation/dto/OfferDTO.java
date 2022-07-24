/**
 * 
 */
package com.bank.debtrenegociation.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
public class OfferDTO {
	

	private Long id;
	private String description;
	private BigDecimal value;
	private Integer installments;
	private List<CustomerDTO> targets;
	private LocalDateTime start;
	private LocalDateTime end;

}
