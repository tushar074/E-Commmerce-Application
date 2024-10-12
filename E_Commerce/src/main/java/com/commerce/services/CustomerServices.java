/**
 * 
 */
package com.commerce.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.commerce.exceptions.FileTypeNotValidException;
import com.commerce.exceptions.ResourceNotFoundException;
import com.commerce.model.Customer;
import com.commerce.modelRequestDto.CustomerRequestDto;
import com.commerce.modelRequestDto.CustomerUpdateRequestDto;
import com.commerce.modelResponseDto.CustomerDetailsResponseDto;
import com.commerce.modelResponseDto.CustomerResponseDto;
import com.commerce.payloads.ApiResponse;

/**
 * @author tushar
 *
 */

public interface CustomerServices {

	CustomerDetailsResponseDto registerCustomer(CustomerRequestDto customerRequestDto) throws ResourceNotFoundException;

	CustomerDetailsResponseDto updateCustomerDetails(String contact, CustomerUpdateRequestDto customerUpdateRequestDto)
			throws ResourceNotFoundException;

	ApiResponse deleteCustomerAccount(String contact) throws ResourceNotFoundException;

	CustomerResponseDto getCustomer(String contact) throws ResourceNotFoundException;

	CustomerDetailsResponseDto updateCustomerImage(String contact, MultipartFile image)
			throws ResourceNotFoundException, IOException, FileTypeNotValidException;

	void serveCustomerImage(String imageName, HttpServletResponse response)
			throws ResourceNotFoundException, IOException, FileTypeNotValidException;

	ApiResponse deleteCustomerImage(String fileName) throws IOException;

	List<CustomerResponseDto> searchByfirstName(String firstName);

	Page<Customer> getAllCustomerDetails(Integer page, Integer size, String sortDirection, String sortBy);

	List<CustomerResponseDto> searchBylastName(String lastName);

	List<CustomerResponseDto> searchByemailId(String email);

	List<CustomerResponseDto> searchByFirstAndLastName(String firstName, String lastName);

}
