/**
 * 
 */
package com.commerce.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tushar
 *
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PickUpOrderRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pickUpOrderRequestId;

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime pickUpOrderTimeStamp;

	@UpdateTimestamp
	@Column(nullable = false)
	private LocalDateTime pickUpOrderUpdatedTimeStamp;

	private LocalDateTime expectedPickUpDate;

	private String pickedUpBy;

	private Boolean isReturnOrderPickedUp;

	@OneToOne
	private Customer customer;

	@OneToOne
	private Order order;

}
