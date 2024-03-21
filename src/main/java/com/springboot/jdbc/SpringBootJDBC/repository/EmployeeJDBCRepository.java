package com.springboot.jdbc.SpringBootJDBC.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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

	public List<EmployeeDTO> findAllEmployees() {

		return jdbcTemplate.query(SELECT_QUERY, new BeanPropertyRowMapper(EmployeeDTO.class));

	}

	public int createEmployee(EmployeeDTO employeeDTO) {
		return jdbcTemplate.update(INSERT_QUERY, employeeDTO.getEmpId(), employeeDTO.getFirstName(), employeeDTO.getLastName(),
				employeeDTO.getMobileNumber(), employeeDTO.getEmailId(), employeeDTO.getAge());
	}
	
	public EmployeeDTO findEmployee(Long empId)  {
		return jdbcTemplate.queryForObject(FIND_EMPLOYEE_QUERY, new BeanPropertyRowMapper<>(EmployeeDTO.class),empId);
	}
	
	public Integer updateEmployee(EmployeeDTO employeeDTO) {
		return jdbcTemplate.update(UPDATE_QUERY, employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getMobileNumber(), employeeDTO.getEmailId(), employeeDTO.getAge(), employeeDTO.getEmpId());
	}
	
	public Integer deleteEmployee(Long empId) {
		return jdbcTemplate.update(DELETE_QUERY,empId);
	}
		

}
