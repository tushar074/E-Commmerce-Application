/**
 * 
 */
package com.commerce.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

import com.commerce.exceptions.FileTypeNotValidException;
import com.commerce.payloads.ImageResponse;

/**
 * @author tushar
 *
 */
public interface FileServices {

	InputStream serveImage(String path, String imageName) throws FileNotFoundException;

	ImageResponse addImage(String path, MultipartFile multipartFile) throws IOException, FileTypeNotValidException;

	boolean delete(String filename) throws IOException;

}
