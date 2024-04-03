package com.springboot.jdbc.SpringBootJDBC.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ApplicationCustomErrorInfo> handleEmployeeException(Exception ex, WebRequest request)
			throws Exception {

		System.out.println("-----exception comming from my customized Handle------");

		ApplicationCustomErrorInfo applicationCustomErrorInfo = new ApplicationCustomErrorInfo(LocalDateTime.now(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ApplicationCustomErrorInfo>(applicationCustomErrorInfo,
				HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<ApplicationCustomErrorInfo> EmployeeNotFoundException(Exception ex, WebRequest request)
			throws Exception {

		System.out.println("-----exception comming from my customized Handle------");

		ApplicationCustomErrorInfo applicationCustomErrorInfo = new ApplicationCustomErrorInfo(LocalDateTime.now(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ApplicationCustomErrorInfo>(applicationCustomErrorInfo, HttpStatus.BAD_REQUEST);

	}

	// When the purpose of the Validation of Application Then we customize our
	// Status code and description
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ApplicationCustomErrorInfo applicationCustomErrorInfo = new ApplicationCustomErrorInfo(LocalDateTime.now(),
				ex.getFieldError().getDefaultMessage(), request.getDescription(false));

		return new ResponseEntity<>(applicationCustomErrorInfo, HttpStatus.BAD_REQUEST);
	}

}
