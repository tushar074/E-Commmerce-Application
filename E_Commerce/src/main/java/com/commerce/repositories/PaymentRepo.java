/**
 * 
 */
package com.commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.commerce.model.Payment;

/**
 * @author tushar
 *
 */

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer> {

	@Override
	default boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
