package com.org.bhfl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.bhfl.entity.Employee;
import com.org.bhfl.repository.EmployeeRespository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRespository employeeRespository;

	public List<Employee> getAll() {
		return employeeRespository.findAll();
	}

	public Employee saveEmployee(Employee employee) {
		employeeRespository.count();
		Employee e = employeeRespository.save(employee);
		return e;
	}

	public List<Employee> findByName(String empName) {
		return employeeRespository.findByName(empName);
	}

	public List<Employee> findByCity(String city) {
		return employeeRespository.findByCity(city);
	}

	public List<Employee> findByIdAndCity(int id, String city) {
		return employeeRespository.findByIdAndCity(id, city);
	}

}
