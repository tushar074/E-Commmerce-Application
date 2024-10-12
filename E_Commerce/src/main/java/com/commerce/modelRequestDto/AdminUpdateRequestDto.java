/**
 * 
 */
package com.commerce.modelRequestDto;

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
public class AdminUpdateRequestDto {

	
	private String firstName;
	
	private String lastName;
	
	private String contact;
	
	private String email;
	
	private String password;
}
