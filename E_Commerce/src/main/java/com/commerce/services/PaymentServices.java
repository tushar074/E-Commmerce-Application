package com.commerce.services;

import java.util.List;

import com.commerce.exceptions.DuplicateResourceException;
import com.commerce.exceptions.ResourceNotFoundException;
import com.commerce.modelRequestDto.PaymentRequestDto;
import com.commerce.modelResponseDto.PaymentResponseDto;
import com.commerce.payloads.ApiResponse;

/**
 * @author tushar
 *
 */

public interface PaymentServices {
	
	
	PaymentResponseDto addPaymentMethod(PaymentRequestDto paymentRequestDto) throws DuplicateResourceException;

	PaymentResponseDto getPaymentMethod(Integer paymentId) throws ResourceNotFoundException;

	ApiResponse deletePaymentMethod(Integer paymentId) throws ResourceNotFoundException;

	PaymentResponseDto revokePaymentMethod(Integer paymentId) throws ResourceNotFoundException;

	List<PaymentResponseDto> getAllPaymentMethods() throws ResourceNotFoundException;

}
