package com.cts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidIdException.class)
	
		public ResponseEntity<String> invalidIdException(InvalidIdException ex)
		{
			return new ResponseEntity<>(ex.toString(),HttpStatus.NOT_ACCEPTABLE);
		}
	}
