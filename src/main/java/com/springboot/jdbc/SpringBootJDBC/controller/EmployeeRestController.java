package com.springboot.jdbc.SpringBootJDBC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jdbc.SpringBootJDBC.model.EmployeeDTO;
import com.springboot.jdbc.SpringBootJDBC.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/findAllEmployees")
	public List<EmployeeDTO> findAllEmp() {
		
		//TODO: Invoke Employee_class
		
		return employeeService.findAllEmployee(); 
	}
	
	@PostMapping("/createEmployee")
	public void createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		
		 employeeService.createEmployee(employeeDTO);
	}
	
	@GetMapping("/findEmployee/{empId}")
	public EmployeeDTO findEmployee(@PathVariable Long empId) {
		return employeeService.findEmployee(empId);
		
	} 
	
/*	@PostMapping("/findEmp")
	public EmployeeDTO findEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return employeeService.findEmployee(employeeDTO.getEmpId());
	}
*/
	
	@PutMapping("/updateEmployee")
	public Integer updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return employeeService.updateEmployee(employeeDTO);
	}
	
	@DeleteMapping("/deleteEmp/{empId}")
	public Integer deleteEmployee(@PathVariable Long empId) {
		return employeeService.deleteEmployee(empId);
	}
}
