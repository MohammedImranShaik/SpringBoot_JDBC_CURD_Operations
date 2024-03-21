package com.springboot.jdbc.SpringBootJDBC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.jdbc.SpringBootJDBC.model.EmployeeDTO;
import com.springboot.jdbc.SpringBootJDBC.repository.EmployeeJDBCRepository;
@Component
public  class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeJDBCRepository employeeJDBCRepository;

	@Override
	public List<EmployeeDTO> findAllEmployee() {
		// TODO Auto-generated method stub
		return employeeJDBCRepository.findAllEmployees();
	}

	@Override
	public int createEmployee(EmployeeDTO employeeDTO) {
		return employeeJDBCRepository.createEmployee(employeeDTO);
		
	}

	@Override
	public EmployeeDTO findEmployee(Long empId) {
		// TODO Auto-generated method stub
		return employeeJDBCRepository.findEmployee(empId);
	}

	@Override
	public Integer updateEmployee(EmployeeDTO employeeDTO) {
		// TODO Auto-generated method stub
		return employeeJDBCRepository.updateEmployee(employeeDTO);
	}

	@Override
	public Integer deleteEmployee(Long empId) {
		// TODO Auto-generated method stub
		return employeeJDBCRepository.deleteEmployee(empId);
		
	}

	

	

}
