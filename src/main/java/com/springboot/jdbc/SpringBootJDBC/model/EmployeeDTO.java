package com.springboot.jdbc.SpringBootJDBC.model;

import org.hibernate.validator.constraints.NotEmpty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EmployeeDTO { //Employee class map with database table like employee
	
	@NotNull
	private Long empId; //column map with id
	
	@NotEmpty(message = "Please Enter the valid First Name")
	private String firstName; // will map with first name
	
	@NotEmpty(message = "Please Enter the Valid Last Name")
	//@Size(max = 1,message = "Please Enter atleast one Charecter ")
	private String lastName;
	
	@NotNull(message = "Please Enter the Valid Mobile Number")
	private Long mobileNumber;
	
	@NotEmpty
	private String emailId;
	
	@NotNull
	private Integer age;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber="
				+ mobileNumber + ", emailId=" + emailId + ", age=" + age + "]";
	}
	
	
	

}
