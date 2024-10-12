package com.commerce.modelResponseDto;

import java.util.HashSet;
import java.util.Set;

import com.commerce.model.Role;

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
public class AdminResponseDto{

	private Integer userId;

	private String firstName;

	private String lastName;
	
	private String contact;

	private String email;
	
	private Set<Role> roles = new HashSet<>();
	
}
