/**
 * 
 */
package com.commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.commerce.model.Role;

/**
 * @author tushar
 *
 */
@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

}
