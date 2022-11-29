package com.emp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@ToString
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	long empId;

	@NotBlank(message = "First Name should not be blank")
	@NotNull(message = "First Name should not be null")
	@Column(name = "First_Name")
	String empFirstName;

	@NotBlank(message = "Last Name should not be blank")
	@NotNull(message = "Last Name should not be null")
	@Column(name = "Last_Name")
	String empLastName;

	@NotBlank(message = "Email should not be blank")
	@NotNull(message = "Email should not be null")
	@Column(name = "Email")
	String empEmail; 

	@Column(name = "Age")
	int empAge;

	public Employee() {

	}
}
