package com.EnquiryModule.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=EnquiryNotFoundException.class)
	public ResponseEntity<ApiError> EnquiryNotFoundExceptionHandler(HttpServletRequest request)
	{
		ApiError error=new ApiError();
		error.setMassage("Enquiry Not Found");
		error.setPath(request.getRequestURI());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setStatusMessage(HttpStatus.NOT_FOUND);
		error.setTimeStamp(new Date());
		return new ResponseEntity<ApiError>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = PancardAlreadyExistException.class)
	public ResponseEntity<ApiError>PancardAlreadyExistException(HttpServletRequest request)
	{
		ApiError error=new ApiError();
		error.setMassage("Pancard Already Exist");
		error.setPath(request.getRequestURI());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setStatusMessage(HttpStatus.NOT_FOUND);
		error.setTimeStamp(new Date());
		return new ResponseEntity<ApiError>(error,HttpStatus.NOT_FOUND);
		
	}

}
