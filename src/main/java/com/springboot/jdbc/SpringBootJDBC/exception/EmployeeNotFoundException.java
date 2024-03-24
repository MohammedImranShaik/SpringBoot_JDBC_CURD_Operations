package com.springboot.jdbc.SpringBootJDBC.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployeeNotFoundException extends RuntimeException {

	 public EmployeeNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		 super(message);
	}
}