/**
 * 
 */
package com.commerce.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tushar
 *
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Role {

	@Id
	private Integer roleId;

	private String roleName;

}
