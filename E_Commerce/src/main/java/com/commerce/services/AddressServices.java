/**
 * 
 */
package com.commerce.services;

import com.commerce.exceptions.ResourceNotFoundException;
import com.commerce.modelRequestDto.AddressRequestDto;
import com.commerce.modelRequestDto.AddressUpdateRequestDto;
import com.commerce.modelResponseDto.AddressResponseDto;
import com.commerce.modelResponseDto.CustomerResponseDto;

/**
 * @author tushar
 *
 */
public interface AddressServices {

	AddressResponseDto getAddressDetails(String customerContact) throws ResourceNotFoundException;


	CustomerResponseDto addAddressDetails(String customerContact, AddressRequestDto addressRequestDto)
			throws ResourceNotFoundException;

	CustomerResponseDto udpateAddressDetails(String customerContact, AddressUpdateRequestDto addressUpdateRequestDto)
			throws ResourceNotFoundException;

}
