/**
 * 
 */
package com.commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.commerce.model.Address;

/**
 * @author tushar
 *
 */
@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

}
