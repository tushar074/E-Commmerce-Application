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
public class CancelOrderResponseDto {

	private Integer cancelOrderRequestId;

	private LocalDateTime cancelTimeStamp;

	private Boolean isOrderCancelled;

	private Boolean isOrderRefunded;
	
	private String status;
	
	private OrderDetailsResponseDto order;
	
	private CustomerDetailsResponseDto customer;
	
	private RefundOrderResponseDto refundOrderRequest;

}
