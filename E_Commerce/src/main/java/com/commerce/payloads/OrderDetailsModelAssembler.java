/**
 * 
 */
package com.commerce.payloads;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.commerce.controllers.CustomerController;
import com.commerce.controllers.OrderController;
import com.commerce.controllers.PaymentController;
import com.commerce.controllers.ProductController;
import com.commerce.exceptions.ResourceNotAllowedException;
import com.commerce.exceptions.ResourceNotFoundException;
import com.commerce.model.Order;
import com.commerce.model.OrderProductDetails;
import com.commerce.modelResponseDto.OrderDetailsResponseDto;

/**
 * @author tushar
 *
 */
@Component
public class OrderDetailsModelAssembler extends RepresentationModelAssemblerSupport<Order, OrderDetailsResponseDto> {

	@Autowired
	private ModelMapper modelMapper;

	public OrderDetailsModelAssembler() {
		super(OrderController.class, OrderDetailsResponseDto.class);
	}

	@Override
	public OrderDetailsResponseDto toModel(Order entity) {

		OrderDetailsResponseDto orderDetailsResponseDto = this.modelMapper.map(entity, OrderDetailsResponseDto.class);

		List<OrderProductDetails> listOfProducts = orderDetailsResponseDto.getListOfProducts();

		for (OrderProductDetails o : listOfProducts) {

			// Self Product Link
			try {
				o.add(linkTo(methodOn(ProductController.class).getProductByIdHandler(o.getProductId())).withSelfRel());
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ResourceNotAllowedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		try {
			// Self Order
			orderDetailsResponseDto
					.add(linkTo(methodOn(OrderController.class).getOrderById(orderDetailsResponseDto.getOrderId()))
							.withSelfRel());

			// Customer Link
			orderDetailsResponseDto.add(
					linkTo(methodOn(CustomerController.class).getCustomerHandler(entity.getCustomer().getContact()))
							.withRel("customer"));

			// Payment Link
			orderDetailsResponseDto.add(linkTo(
					methodOn(PaymentController.class).getPaymentMethodHandler(entity.getPayment().getPaymentId()))
					.withRel("payment"));

		
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		} catch (ResourceNotAllowedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return orderDetailsResponseDto;
	}

}
