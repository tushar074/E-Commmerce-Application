/**
 * 
 */
package com.commerce.services;

import java.util.List;

import com.commerce.exceptions.ResourceNotFoundException;
import com.commerce.modelRequestDto.AdminRequestDto;
import com.commerce.modelRequestDto.AdminUpdateRequestDto;
import com.commerce.modelResponseDto.AdminResponseDto;
import com.commerce.payloads.ApiResponse;

/**
 * @author tushar
 *
 */
public interface AdminServices {

	AdminResponseDto registerAdmin(AdminRequestDto adminRequestDto) throws ResourceNotFoundException;

	AdminResponseDto updateAdminDetails(AdminUpdateRequestDto userdto, Integer adminId)
			throws ResourceNotFoundException;

	AdminResponseDto getAdminDetailsById(Integer adminId) throws ResourceNotFoundException;

	List<AdminResponseDto> getAllAdmins();

	ApiResponse deleteAdminById(Integer adminId) throws ResourceNotFoundException;
	
	
}
