package com.springboot.jdbc.SpringBootJDBC.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.jdbc.SpringBootJDBC.model.EmployeeDTO;


public interface EmployeeService {
	
	List<EmployeeDTO> findAllEmployee();
	
	int createEmployee(EmployeeDTO employeeDTO);
	
	EmployeeDTO findEmployee(Long empId);
	
	Integer updateEmployee(EmployeeDTO employeeDTO);
	
	Integer deleteEmployee(Long empId);

	

	
		 
	}


