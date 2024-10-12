/**
 * 
 */
package com.commerce.services;


import com.commerce.exceptions.ResourceNotAllowedException;
import com.commerce.exceptions.ResourceNotFoundException;
import com.commerce.modelResponseDto.CartResponseDto;
import com.commerce.modelResponseDto.OrderResponseDto;
import com.commerce.payloads.ApiResponse;

/**
 * @author tushar
 *
 */

public interface CartServices {
	

	ApiResponse addProducttoCart(String contact, Integer productId, Integer productQuantity)
			throws ResourceNotFoundException, ResourceNotAllowedException;

	ApiResponse updateCartProductQuantity(String contact, Integer productId, Integer quantity) throws ResourceNotFoundException, ResourceNotAllowedException;

	CartResponseDto emptyCart(String contact) throws ResourceNotFoundException;

	CartResponseDto deleteProductfromCart(String contact, Integer productId) throws ResourceNotFoundException;
	
	CartResponseDto getCart(String contact) throws ResourceNotFoundException;


	OrderResponseDto buyCart(String contact, Integer paymentId) throws ResourceNotFoundException, ResourceNotAllowedException;
	

}
