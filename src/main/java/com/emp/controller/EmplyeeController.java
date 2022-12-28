package com.emp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.entity.Employee;
import com.emp.service.EmployeeService;

@RestController
public class EmplyeeController {

	@Autowired
	public EmployeeService employeeService;

	@PostMapping("/addEmployeeDetail")
	public String addEmployeeDetail(@Valid @RequestBody Employee employee) {
		employeeService.addEmployeeDetail(employee);
		return "Insert detail successfully";
	}

	@PostMapping("/addAllEmployeeDetails")
	public String addAllEmployeeDetails(@Valid @RequestBody List<Employee> employeeList) {
		employeeService.addAllEmployeeDetails(employeeList);
		return "Insert all details successfully";
	}

	@GetMapping("/getEmployeeDetailById/{empId}")
	public ResponseEntity<Employee> getEmployeeDetailById(@PathVariable("empId") long empId) {
		Employee employeeDetailById = employeeService.getEmployeeDetailById(empId);
		return new ResponseEntity<Employee>(employeeDetailById, HttpStatus.OK);
	}

	@GetMapping("/getAllEmployeeDetails")
	public ResponseEntity<List<Employee>> getAllEmployeeDetails() {
		List<Employee> allEmployeeDetails = employeeService.getAllEmployeeDetails();
		System.out.println("");
		return new ResponseEntity<List<Employee>>(allEmployeeDetails, HttpStatus.OK);
	}

	@PutMapping("/updateEmployeeDetails/{empId}")
	public String updateEmployeeDetails(@RequestBody Employee employee , @PathVariable long empId) {
		employeeService.updateEmployeeDetails(employee,empId);
		return "Update employee detail succeddfully";
	}

	@DeleteMapping("/deleteEmployeeById/{empId}")
	public String deleteEmployeeById(@PathVariable("empId") long empId) {
		employeeService.deleteEmployeeById(empId);
		return "Delete employee detail by Id successfully ";
	}

	@DeleteMapping("/deleteAllEmployeeDetails")
	public String deleteAllEmployeeDetails() { 
		employeeService.deleteAllEmployeeDetails();
		return "Delete all employee detail successfully ";
	}

}
