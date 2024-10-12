/**
 * 
 */
package com.commerce.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tushar
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Image {

	private String imageName;

	private String imageUrl;

}
