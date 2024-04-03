package com.org.bhfl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.bhfl.entity.Employee;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

	public List<Employee> findByName(String empName);

	public List<Employee> findByCity(String city);

	public List<Employee> findByIdAndCity(int id, String city);

	public List<Employee> findByCityNot(String city);

//	public List<Employee> findByStateIn(String state);

}
