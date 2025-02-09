/**
 * 
 */
package com.commerce.services;

import org.springframework.data.domain.Page;

import com.commerce.exceptions.DuplicateResourceException;
import com.commerce.exceptions.ResourceNotAllowedException;
import com.commerce.exceptions.ResourceNotFoundException;
import com.commerce.model.Order;
import com.commerce.model.PickUpOrderRequest;
import com.commerce.model.RefundOrderRequest;
import com.commerce.model.ReplaceOrderRequest;
import com.commerce.modelResponseDto.OrderResponseDto;
import com.commerce.modelResponseDto.RefundOrderResponseDto;
import com.commerce.modelResponseDto.ReturnReplaceOrderResponseDto;
import com.commerce.payloads.ApiResponse;

/**
 * @author tushar
 *
 */
public interface OrderServices {

	// OrderResponse
	ApiResponse orderProduct(String contact, Integer paymentId, Integer productId, Integer quantity)
			throws ResourceNotFoundException, ResourceNotAllowedException;

	OrderResponseDto getOrderByOrderId(Integer orderId) throws ResourceNotFoundException;

	ApiResponse deleteOrder(Integer orderId) throws ResourceNotFoundException;

	ApiResponse markDelivered(Integer orderId) throws ResourceNotFoundException;

	OrderResponseDto updateOrderStatus(Integer orderId, String status) throws ResourceNotFoundException;

	// Take Approval From Admin and get Approved;
	ApiResponse cancelOrder(Integer orderId) throws ResourceNotFoundException, DuplicateResourceException;

	ApiResponse revokeOrderPickUpStatus(String pickedUpBy, Integer orderId)
			throws ResourceNotFoundException, DuplicateResourceException;

	ApiResponse returnforReplacementAndPickupOrder(Integer orderId)
			throws ResourceNotFoundException, DuplicateResourceException;

	ApiResponse returnforRefundAndPickupOrder(Integer orderId)
			throws ResourceNotFoundException, DuplicateResourceException;

	ReturnReplaceOrderResponseDto approveReplacementRequest(String approvedBy, Integer replaceOrderRequestId)
			throws ResourceNotFoundException, ResourceNotAllowedException, Exception;

	Page<Order> getAllOrdersByCustomer(String contact, Integer pageNumber, Integer pageSize, String sortBy,
			String sortDirection) throws ResourceNotFoundException;

	Page<Order> getAllOrders(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection);

	Page<RefundOrderRequest> getAllPendingRefundRequests(Integer pageNumber, Integer pageSize, String sortBy,
			String sortDirection);

	Page<PickUpOrderRequest> getAllPendingPickupRequests(Integer pageNumber, Integer pageSize, String sortBy,
			String sortDirection);

	Page<PickUpOrderRequest> getAllApprovedPickupRequests(Integer pageNumber, Integer pageSize, String sortBy,
			String sortDirection);

	Page<ReplaceOrderRequest> getAllApprovedReplacementRequests(Integer pageNumber, Integer pageSize, String sortBy,
			String sortDirection);

	Page<ReplaceOrderRequest> getAllPendingReplacementRequests(Integer pageNumber, Integer pageSize, String sortBy,
			String sortDirection);

	Page<RefundOrderRequest> getAllApprovedRefundRequests(Integer pageNumber, Integer pageSize, String sortBy,
			String sortDirection);

	RefundOrderResponseDto approveRefundById(String approvedBy, Integer refundOrderRequestId)
			throws ResourceNotFoundException;

	Page<ReplaceOrderRequest> getAllReplacedOrdersByCustomer(String contact, Integer pageNumber, Integer pageSize,
			String sortBy, String sortDirection) throws ResourceNotFoundException;

	Page<RefundOrderRequest> getAllRefundOrdersByCustomer(String contact, Integer pageNumber, Integer pageSize,
			String sortBy, String sortDirection) throws ResourceNotFoundException;

	// sales Made Today
	Page<Order> getSalesMadeToday(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection);

	// sales Made Last Week
	Page<Order> getSalesMadeLastWeek(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection);
	
	//sales Made This Week
	Page<Order> getSalesMadeThisWeek(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection);
	
	//sales Made Last Months
	Page<Order> getSalesMadeMonth(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection);
	
	//sales Made Jan Dec
	Page<Order> getSalesMadeJanDec(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection);

	// Try To Implement
	// Change rating as per reviews

}
