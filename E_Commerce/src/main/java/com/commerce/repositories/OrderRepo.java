/**
 * 
 */
package com.commerce.repositories;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.commerce.model.Customer;
import com.commerce.model.Order;

/**
 * @author tushar
 *
 */
@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

	Page<Order> findByCustomer(Customer customer, Pageable pageable);

	// sales made today,sales made last week, last month, Jan - Dec;
	Page<Order> findAllByOrderTimeStampBetween(LocalDateTime start, LocalDateTime end, Pageable pageable);

}
