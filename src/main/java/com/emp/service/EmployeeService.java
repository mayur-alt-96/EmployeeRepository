package com.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dao.EmployeeDao;
import com.emp.entity.Employee;
import com.emp.utils.StringUtils;

@Service
public class EmployeeService {

	@Autowired
	public EmployeeDao employeeDao;

	public void addEmployeeDetail(Employee employee) {
		employeeDao.save(employee);
	}

	public List<Employee> addAllEmployeeDetails(List<Employee> employeeList) {
		return employeeDao.saveAll(employeeList);
	}

	public Employee getEmployeeDetailById(long empId) {
		Optional<Employee> empFindById = employeeDao.findById(empId);
		return empFindById.get();
	}

	public List<Employee> getAllEmployeeDetails() {
		return employeeDao.findAll();
	}

	public void deleteEmployeeById(long empId) {
		employeeDao.deleteById(empId);
	}

	public void deleteAllEmployeeDetails() {
		employeeDao.deleteAll();
	}

	public void updateEmployeeDetails(Employee updateEmpDetails, long empId) {
		Optional<Employee> findById = employeeDao.findById(empId);
		Employee employee = findById.get();
		if (StringUtils.isNotNullAndBlank(updateEmpDetails.getEmpFirstName())) {
			employee.setEmpFirstName(updateEmpDetails.getEmpFirstName());
		}
		if (StringUtils.isNotNullAndBlank(updateEmpDetails.getEmpLastName())) {
			employee.setEmpLastName(updateEmpDetails.getEmpLastName());
		}
		if (StringUtils.isNotNullAndBlank(updateEmpDetails.getEmpEmail())) {
			employee.setEmpEmail(updateEmpDetails.getEmpEmail());
		}

		if (StringUtils.isGreaterThanZero(updateEmpDetails.getEmpAge())) {
			employee.setEmpAge(updateEmpDetails.getEmpAge());
		}
		employeeDao.save(employee);
	}
}
