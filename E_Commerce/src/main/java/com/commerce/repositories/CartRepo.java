/**
 * 
 */
package com.commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.commerce.model.Cart;

/**
 * @author tushar
 *
 */
@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{
	
	
	
}
