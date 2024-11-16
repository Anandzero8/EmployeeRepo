package com.student.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptions {
	@ExceptionHandler(AgeException.class)
	public ResponseEntity<Object> handleAge(AgeException ae){
		return new ResponseEntity<Object>("Student age less than 18 cannot be created", HttpStatus.BAD_REQUEST);
	}
}
