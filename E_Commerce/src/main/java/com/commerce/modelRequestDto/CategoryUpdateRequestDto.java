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
public class CategoryUpdateRequestDto {

	private String categoryName;
	
	private String categoryDescription;
	
	private Boolean active;
	
}
