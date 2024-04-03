package com.springboot.jdbc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jdbc.SpringBootJDBC.config.DataBaseConfigProperty;

@RestController
public class DatabaseRestController {
	
	@Autowired
	private DataBaseConfigProperty dataBaseConfigProperty;

	@GetMapping("/dbProperties")
	public DataBaseConfigProperty getDatabaseInfo() {
		
		return dataBaseConfigProperty;
		
	}
}
