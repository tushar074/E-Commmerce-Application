/**
 * 
 */
package com.commerce.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.commerce.model.Customer;
import com.commerce.model.Feedback;
import com.commerce.model.Order;

/**
 * @author tushar
 *
 */
@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {

	Page<Feedback> findByCustomer(Customer customer, Pageable pageable);

	Page<Feedback> findByOrder(Order order, Pageable pageable);

}
