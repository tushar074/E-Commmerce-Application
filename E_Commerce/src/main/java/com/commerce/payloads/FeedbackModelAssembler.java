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

import com.commerce.controllers.FeedbackController;
import com.commerce.exceptions.ResourceNotAllowedException;
import com.commerce.exceptions.ResourceNotFoundException;
import com.commerce.model.Feedback;
import com.commerce.modelResponseDto.FeedbackResponseDto;

/**
 * @author tushar
 *
 */
@Component
public class FeedbackModelAssembler extends RepresentationModelAssemblerSupport<Feedback, FeedbackResponseDto> {

	@Autowired
	private ModelMapper modelMapper;

	public FeedbackModelAssembler() {

		super(FeedbackController.class, FeedbackResponseDto.class);

	}

	@Override
	public FeedbackResponseDto toModel(Feedback entity) {

		FeedbackResponseDto feedbackResponseDto = this.modelMapper.map(entity, FeedbackResponseDto.class);

		try {
			try {
				feedbackResponseDto
						.add(linkTo(methodOn(FeedbackController.class).getFeedbackById(feedbackResponseDto.getFeedbackId()))
								.withSelfRel());
			} catch (ResourceNotAllowedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}

		return feedbackResponseDto;
	}

}
