/**
 * 
 */
package com.commerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.commerce.model.Order;
import com.commerce.model.RefundOrderRequest;
import com.commerce.model.ReplaceOrderRequest;
import com.commerce.model.ReturnOrderRequest;

/**
 * @author tushar
 *
 */
@Repository
public interface ReturnOrderRequestRepo extends JpaRepository<ReturnOrderRequest, Integer> {

	Optional<ReturnOrderRequest> findByOrder(Order order);
	
	Optional<ReturnOrderRequest> findByReplaceOrderRequest(ReplaceOrderRequest replaceOrderRequest);
	
	Optional<ReturnOrderRequest> findByRefundOrderRequest(RefundOrderRequest refundOrderRequest);
}
