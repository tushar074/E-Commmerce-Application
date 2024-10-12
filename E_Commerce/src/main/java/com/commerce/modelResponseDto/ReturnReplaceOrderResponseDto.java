/**
 * 
 */
package com.commerce.modelResponseDto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tushar
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnReplaceOrderResponseDto {

	private Integer returnOrderRequestId;
	
	private Boolean returnForReplacement;

	private LocalDateTime returnTimeStamp;
	
	private LocalDateTime returnUpdatedTimeStamp;

	private Boolean isReturnOrderPickedup;
	
	private String status;

	private OrderDetailsResponseDto order;

	private CustomerResponseDto customer;

	private PickUpOrderResponseDto pickUpOrderRequest;

	private ReplaceOrderResponseDto replaceOrderRequest;

}
