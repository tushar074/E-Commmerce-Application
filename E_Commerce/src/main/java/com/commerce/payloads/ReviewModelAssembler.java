/**
 * 
 */
package com.commerce.payloads;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.commerce.controllers.ReviewController;
import com.commerce.exceptions.ResourceNotAllowedException;
import com.commerce.exceptions.ResourceNotFoundException;
import com.commerce.model.Review;
import com.commerce.modelResponseDto.ReviewResponseDto;

/**
 * @author tushar
 *
 */
@Component
public class ReviewModelAssembler extends RepresentationModelAssemblerSupport<Review, ReviewResponseDto> {

	@Autowired
	private ModelMapper modelMapper;

	public ReviewModelAssembler() {

		super(ReviewController.class, ReviewResponseDto.class);

	}

	@Override
	public ReviewResponseDto toModel(Review entity) {

		ReviewResponseDto reviewResponseDto = this.modelMapper.map(entity, ReviewResponseDto.class);

		try {
			try {
				reviewResponseDto
						.add(linkTo(methodOn(ReviewController.class).getReviewById(reviewResponseDto.getReviewId()))
								.withSelfRel());
			} catch (ResourceNotAllowedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}

		return reviewResponseDto;
	}

}
