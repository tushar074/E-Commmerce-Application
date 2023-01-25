/**
 * 
 */
package com.masai.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.masai.exceptions.ResourceNotFoundException;
import com.masai.modelRequestDto.CategoryRequestDto;
import com.masai.modelRequestDto.CategoryUpdateRequestDto;
import com.masai.modelResponseDto.CategoryResponseDto;
import com.masai.payloads.ApiResponse;
import com.masai.payloads.AppConstants;
import com.masai.payloads.PageResponse;
import com.masai.services.CategoryServices;

/**
 * @author tejas
 *
 */
@RestController
@RequestMapping("/bestbuy/categories")
public class CategoryController {

	@Autowired
	private CategoryServices categoryServices;

	@GetMapping("/all")
	public ResponseEntity<List<CategoryResponseDto>> getAllCategoriesHandler() {

		List<CategoryResponseDto> allCategories = this.categoryServices.getAllCategories();

		return new ResponseEntity<List<CategoryResponseDto>>(allCategories, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<CategoryResponseDto> addCategoryHandler(@Valid @RequestBody CategoryRequestDto categoryRequestDto) {

		CategoryResponseDto category = this.categoryServices.addCategory(categoryRequestDto);

		return new ResponseEntity<CategoryResponseDto>(category, HttpStatus.ACCEPTED);
	}

	@PutMapping("/{categoryId}/update")
	public ResponseEntity<CategoryResponseDto> updateCategoryHandler(@PathVariable("categoryId") Integer categoryId,
			@Valid @RequestBody CategoryUpdateRequestDto categoryRequestDto) throws ResourceNotFoundException {

		CategoryResponseDto updatedCategory = this.categoryServices.updateCategory(categoryId, categoryRequestDto);

		return new ResponseEntity<CategoryResponseDto>(updatedCategory, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{categoryId}/delete")
	public ResponseEntity<ApiResponse> deleteCategoryByIdHandler(@PathVariable("categoryId") Integer categoryId)
			throws ResourceNotFoundException {

		ApiResponse apiResponse = this.categoryServices.deleteCategoryById(categoryId);

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
	}

	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryResponseDto> getCategoryHandler(@PathVariable("categoryId") Integer categoryId)
			throws ResourceNotFoundException {

		CategoryResponseDto category = this.categoryServices.getCategory(categoryId);

		return new ResponseEntity<CategoryResponseDto>(category, HttpStatus.FOUND);
	}

	@GetMapping("/all/page")
	public ResponseEntity<PageResponse> getAllCategoriesByPageHandler(
			@RequestParam(defaultValue = AppConstants.PAGENUMBER, required = false) Integer pageNumber,
			@RequestParam(defaultValue = AppConstants.PAGESIZE, required = false) Integer pageSize) {

		PageResponse categoriesByPage = this.categoryServices.getAllCategoriesByPage(pageNumber, pageSize);

		return new ResponseEntity<PageResponse>(categoriesByPage, HttpStatus.OK);
	}

	@GetMapping("/all/sortby")
	public ResponseEntity<PageResponse> getSortedByAnyCategoryDetailsByPageHandler(
			@RequestParam(defaultValue = AppConstants.PAGENUMBER, required = false) Integer pageNumber,
			@RequestParam(defaultValue = AppConstants.PAGESIZE, required = false) Integer pageSize,
			@RequestParam(defaultValue = AppConstants.CATEGORYSORTBY, required = false) String sortBy,
			@RequestParam(defaultValue = AppConstants.SORTDIRECTION, required = false) String sortDirection) {

		PageResponse categoriesByPage = this.categoryServices.getSortedByAnyCategoryDetailsByPage(pageNumber, pageSize,
				sortBy, sortDirection);

		return new ResponseEntity<PageResponse>(categoriesByPage, HttpStatus.OK);

	}

	@GetMapping("/all/search/{keyword}")
	public ResponseEntity<List<CategoryResponseDto>> searchCategoriesByKeywordHandler(
			@PathVariable("keyword") String keyword) {

		List<CategoryResponseDto> categoriesByKeyword = this.categoryServices.searchCategoriesByKeyword(keyword);

		return new ResponseEntity<List<CategoryResponseDto>>(categoriesByKeyword, HttpStatus.FOUND);
	}

}
