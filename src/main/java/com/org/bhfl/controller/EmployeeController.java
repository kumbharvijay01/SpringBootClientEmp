package com.org.bhfl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.org.bhfl.dto.IfscCode;
import com.org.bhfl.entity.Address;
import com.org.bhfl.entity.CityMaster;
import com.org.bhfl.entity.Employee;
import com.org.bhfl.repository.AddressRepository;
import com.org.bhfl.repository.CityMasterRepository;
import com.org.bhfl.repository.EmployeeRespository;
import com.org.bhfl.service.EmployeeService;

//import lombok.extern.slf4j.Slf4j;

@RestController
//@Slf4j
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	CityMasterRepository cityMasterRepository;

	@Autowired
	EmployeeRespository employeeRespository;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/getifsc")
	public ResponseEntity<Object> getifsc(@RequestParam String ifscCode) {
		ResponseEntity<Object> resp = null;
		resp = restTemplate.getForEntity("https://ifsc.razorpay.com/" + ifscCode, Object.class);
		if (resp.getStatusCodeValue() == 200) {
			return resp;
		} else {
			return null;
		}

	}

	@PostMapping("/getifsc1")
	public ResponseEntity<Object> getifsc1(@RequestBody IfscCode ifscCode) {
		ResponseEntity<Object> resp = null;
//		resp = restTemplate.getForEntity("https://ifsc.razorpay.com/" + ifscCode.getIfsc(), Object.class);
		if (resp.getStatusCodeValue() == 200) {
			return resp;
		} else {
			return null;
		}

//		restTemplate.
	}

	@GetMapping("/getemployeenew")
	public List<Employee> getEmployeenew() {
		return employeeRespository.findAll();
	}

	@GetMapping("/getemployee")
	public List<Employee> getEmployee() {
		return employeeService.getAll();
	}

	@PostMapping("/addemployee")
	public Employee addEmployee(@RequestBody Employee employee) {
//		if (employee.getCity() == null) {
////			log.info("City Cann't be Null");
//		}
		Address address = new Address();
		address.setStreet("MG Road");
		addressRepository.save(address);
		CityMaster cityMaster = new CityMaster();
		cityMaster.setCityName("PUNE");
		cityMasterRepository.save(cityMaster);
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("/fetchbycity")
	public List<Employee> findByCity() {
		return employeeService.findByCity("Pune");
	}

	@GetMapping("/fetchbycityandid")
	public List<Employee> findByCityandid() {
		return employeeService.findByIdAndCity(2, "Pune");
	}

}
