/**
 * 
 */
package com.commerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.commerce.model.CancelOrderRequest;
import com.commerce.model.Order;

/**
 * @author tushar
 *
 */
@Repository
public interface CancelOrderRequestRepo extends JpaRepository<CancelOrderRequest, Integer> {
	
	Optional<CancelOrderRequest> findByOrder(Order order);
	
	
}
