package com.springboot.jdbc.SpringBootJDBC.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.jdbc.SpringBootJDBC.exception.EmployeeNotFoundException;
import com.springboot.jdbc.SpringBootJDBC.model.EmployeeDTO;

@Repository
public class EmployeeJDBCRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static String SELECT_QUERY = "SELECT * FROM EMPLOYEE";

	private static String INSERT_QUERY = "INSERT INTO EMPLOYEE(EMPID,FIRSTNAME,LASTNAME,MOBILENUMBER,EMAILID,AGE) VALUES(?,?,?,?,?,?)";

	private static String FIND_EMPLOYEE_QUERY = "SELECT * FROM EMPLOYEE WHERE EMPID = ?";

	private static String UPDATE_QUERY = "UPDATE EMPLOYEE SET FIRSTNAME=?, LASTNAME=?, MOBILENUMBER=?, EMAILID=?, AGE=? WHERE EMPID=?";

	private static String DELETE_QUERY = "DELETE FROM EMPLOYEE WHERE EMPID=?";

	
	// TODO: To see the all the data By using SELECT Query
	public List<EmployeeDTO> findAllEmployees() {

		return jdbcTemplate.query(SELECT_QUERY, new BeanPropertyRowMapper(EmployeeDTO.class));

	}
	
    // TODO: To create the Employee data by using INSERT query
	public int createEmployee(EmployeeDTO employeeDTO) {
		return jdbcTemplate.update(INSERT_QUERY, employeeDTO.getEmpId(), employeeDTO.getFirstName(), employeeDTO.getLastName(),
				employeeDTO.getMobileNumber(), employeeDTO.getEmailId(), employeeDTO.getAge());
	}
	
	// TODO: To find the data from the existing the Data
	//If the data doesn't have then having the exception then we can Customized exception
	public EmployeeDTO findEmployee(Long empId)  {
		
		EmployeeDTO employeeDTO;
		
		try {
		employeeDTO =	jdbcTemplate.queryForObject(FIND_EMPLOYEE_QUERY, new BeanPropertyRowMapper<>(EmployeeDTO.class),empId);
		}catch(EmptyResultDataAccessException e) {
			throw new EmployeeNotFoundException("empId= "+empId+ " not found in the DataBase");
		}
		
		return employeeDTO;
	}
	
	
	//TODO : from the existing data we can update what we need from the empId by using UPDATE Command
	public Integer updateEmployee(EmployeeDTO employeeDTO) {
		return jdbcTemplate.update(UPDATE_QUERY, employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getMobileNumber(), employeeDTO.getEmailId(), employeeDTO.getAge(), employeeDTO.getEmpId());
	}
	
	//TODO : From the existing data we can delete specific employee by using DELETE Command
	public Integer deleteEmployee(Long empId) {
		return jdbcTemplate.update(DELETE_QUERY,empId);
	}
		

}
