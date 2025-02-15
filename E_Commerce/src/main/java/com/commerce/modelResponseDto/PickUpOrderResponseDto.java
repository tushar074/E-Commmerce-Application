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
public class PickUpOrderResponseDto {

	private Integer pickUpOrderRequestId;

	private LocalDateTime pickUpOrderTimeStamp;

	private LocalDateTime pickUpOrderUpdatedTimeStamp;

	private Boolean isReturnOrderPickedUp;

	private LocalDateTime expectedPickUpDate;

}
