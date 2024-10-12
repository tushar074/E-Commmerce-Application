/**
 * 
 */
package com.commerce.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.commerce.exceptions.ResourceNotFoundException;
import com.commerce.model.Category;
import com.commerce.modelRequestDto.CategoryRequestDto;
import com.commerce.modelRequestDto.CategoryUpdateRequestDto;
import com.commerce.modelResponseDto.CategoryResponseDto;
import com.commerce.payloads.ApiResponse;

/**
 * @author tushar
 *
 */
public interface CategoryServices {

	List<CategoryResponseDto> getAllCategories();


	CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto);


	ApiResponse deleteCategoryById(Integer categoryId) throws ResourceNotFoundException;

	CategoryResponseDto getCategory(Integer categoryId) throws ResourceNotFoundException;

	Page<Category> getAllCategoriesByPage(Integer page, Integer size);

	Page<Category> getSortedByAnyCategoryDetailsByPage(Integer page, Integer size, String sortBy, String sortDirection);

	List<CategoryResponseDto> searchCategoriesByKeyword(String keyword);


	CategoryResponseDto updateCategory(Integer categoryId, CategoryUpdateRequestDto categoryRequestDto)
			throws ResourceNotFoundException;



}
