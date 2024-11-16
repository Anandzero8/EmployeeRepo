package com.webapp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.webapp.Entity.Employee;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(AgeException.class)
	public ResponseEntity<Object> handleAge(AgeException ar){
		return new ResponseEntity<Object>("Age < 18 is not valid",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<Object> handleNames(NameNotFoundException ne){
		return new ResponseEntity<Object>("Enter Employee Name", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NameAlreadyRegisteredException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String NameAlreadyExist(NameAlreadyRegisteredException na) {
		return na.getMessage();
	}
	

}
