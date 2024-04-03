package com.springboot.jdbc.SpringBootJDBC.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataBaseRestController {
	
	private DataBaseConfigProperty dataBaseConfigProperty;
	
	@GetMapping("/DataBaseProperties")
	public DataBaseConfigProperty getConfig() {
		return dataBaseConfigProperty;
	}

}
