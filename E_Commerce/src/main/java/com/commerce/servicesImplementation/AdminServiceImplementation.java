/**
 * 
 */
package com.commerce.servicesImplementation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.commerce.exceptions.ResourceNotFoundException;
import com.commerce.model.Cart;
import com.commerce.model.CartProductDetails;
import com.commerce.model.Customer;
import com.commerce.model.Role;
import com.commerce.modelRequestDto.AdminRequestDto;
import com.commerce.modelRequestDto.AdminUpdateRequestDto;
import com.commerce.modelResponseDto.AdminResponseDto;
import com.commerce.payloads.ApiResponse;
import com.commerce.payloads.AppConstants;
import com.commerce.repositories.CustomerRepo;
import com.commerce.repositories.RoleRepo;
import com.commerce.services.AdminServices;

/**
 * @author tushar
 *
 */
@Service
public class AdminServiceImplementation implements AdminServices {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public AdminResponseDto registerAdmin(AdminRequestDto adminRequestDto) throws ResourceNotFoundException {
		
		Customer customer = this.toAdmin(adminRequestDto);
		
		// Can set Customer for a single role as well

		Set<Role> roles = customer.getRoles();

		Role userRole = this.roleRepo.findById(AppConstants.ROLE_USER)
				.orElseThrow(() -> new ResourceNotFoundException("Role", "Role Id", AppConstants.ROLE_USER));

		Role adminRole = this.roleRepo.findById(AppConstants.ROLE_ADMIN)
				.orElseThrow(() -> new ResourceNotFoundException("Role", "Role Id", AppConstants.ROLE_ADMIN));

		roles.add(userRole);
		roles.add(adminRole);

		customer.setRoles(roles);

		// Encoding Password
		customer.setPassword(passwordEncoder.encode(adminRequestDto.getPassword()));
		
			
		Cart cart = new Cart();

		List<CartProductDetails> listOfProducts = new ArrayList<>();

		cart.setCartQuantity(0);
		cart.setCartTotalAmount(0.0);
		cart.setListOfProducts(listOfProducts);
		
		customer.setCart(cart);
		
		Customer savedAdmin = this.customerRepo.save(customer);

		return toAdminResponseDto(savedAdmin);
	}

	@Override
	public AdminResponseDto updateAdminDetails(AdminUpdateRequestDto adminUpdateRequestDto, Integer adminId)
			throws ResourceNotFoundException {

		Customer admin = customerRepo.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "Customer Id", adminId));

		if (adminUpdateRequestDto.getContact() == null) {
			admin.setContact(admin.getContact());
		} else {
			admin.setContact(adminUpdateRequestDto.getContact());
		}
		if (adminUpdateRequestDto.getEmail() == null) {
			admin.setEmail(admin.getEmail());
		} else {
			admin.setEmail(adminUpdateRequestDto.getEmail());
		}
		if (adminUpdateRequestDto.getFirstName() == null) {
			admin.setFirstName(admin.getFirstName());
		} else {
			admin.setFirstName(adminUpdateRequestDto.getFirstName());
		}
		if (adminUpdateRequestDto.getLastName() == null) {
			admin.setLastName(admin.getLastName());
		} else {
			admin.setLastName(adminUpdateRequestDto.getLastName());
		}
		if (adminUpdateRequestDto.getPassword() == null) {
			admin.setPassword(admin.getPassword());
		} else {
			admin.setPassword(passwordEncoder.encode(adminUpdateRequestDto.getLastName()));
		}

		Customer savedAdmin = this.customerRepo.save(admin);

		return this.toAdminResponseDto(savedAdmin);
	}

	@Override
	public AdminResponseDto getAdminDetailsById(Integer adminId) throws ResourceNotFoundException {

		Customer admin = customerRepo.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "Customer Id", adminId));

		return this.toAdminResponseDto(admin);

	}

	@Override
	public List<AdminResponseDto> getAllAdmins() {

		List<Customer> findAll = this.customerRepo.findAll();

		return findAll.stream().map(this::toAdminResponseDto).collect(Collectors.toList());
	}

	@Override
	public ApiResponse deleteAdminById(Integer adminId) throws ResourceNotFoundException {

		Customer admin = customerRepo.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "Customer Id", adminId));

		customerRepo.delete(admin);

		return new ApiResponse(LocalDateTime.now(), "Customer Account Deleted Successfully !", true, admin);
	}

	// Model Mapper Methods

	private Customer toAdmin(AdminRequestDto adminRequestDto) {

		return this.modelMapper.map(adminRequestDto, Customer.class);

	}

	private AdminResponseDto toAdminResponseDto(Customer customer) {

		return this.modelMapper.map(customer, AdminResponseDto.class);

	}

}
