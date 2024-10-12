/**
 * 
 */
package com.commerce.payloads;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.commerce.controllers.ProductController;
import com.commerce.exceptions.ResourceNotAllowedException;
import com.commerce.exceptions.ResourceNotFoundException;
import com.commerce.model.OrderProductDetails;

/**
 * @author tushar
 *
 */
@Component
public class OrderProductDetailsModelAssembler
		implements RepresentationModelAssembler<OrderProductDetails, EntityModel<OrderProductDetails>> {

	@Autowired
	private ModelMapper modelMapper;

	public EntityModel<OrderProductDetails> toModel(OrderProductDetails entity) {

		OrderProductDetails orderProductDetails = this.modelMapper.map(entity, OrderProductDetails.class);

		EntityModel<OrderProductDetails> model = EntityModel.of(orderProductDetails);

		// Self Link
		try {
			model.add(linkTo(methodOn(ProductController.class).getProductByIdHandler(model.getContent().getProductId()))
					.withSelfRel());
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ResourceNotAllowedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;

	}

}
