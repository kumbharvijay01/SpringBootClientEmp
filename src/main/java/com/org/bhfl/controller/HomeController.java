/**
 * 
 */
package com.org.bhfl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.org.bhfl.dto.EmployeeDto;

/**
 * 
 */
@RestController
public class HomeController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/callapi")
	public ResponseEntity<String> callapi() {

		ResponseEntity<String> resp = restTemplate.getForEntity("https://dummy.restapiexample.com/api/v1/employeesD",
				String.class);

		System.out.println(resp.getStatusCodeValue());
		System.out.println(resp.getBody());
		System.out.println(resp.getHeaders());
		System.out.println();
		if (resp.getStatusCodeValue() == 200) {
			return new ResponseEntity<String>(resp.getBody(), resp.getStatusCode());
		} else {
			return new ResponseEntity<String>("CUSTOM MESSAGE ", resp.getStatusCode());
		}
//		return resp.getBody();

	}

	@GetMapping("/callapi1")
	public ResponseEntity<Object> callapi1() {

		ResponseEntity<Object> resp = restTemplate
				.getForEntity("https://restcountries.com/v3.1/independent?status=true", Object.class);
		System.out.println(resp.getStatusCodeValue());
		System.out.println(resp.getBody());
		System.out.println(resp.getHeaders());

		return new ResponseEntity<Object>(resp.getBody(), resp.getStatusCode());
	}

	@PostMapping("/createemployee")
	public void createEmployee() {

		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setName("ABC");
		employeeDto.setAge("20");
		employeeDto.setSalary("1000");
		String url = "https://dummy.restapiexample.com/api/v1/create";
		String personResultAsJsonStr = restTemplate.postForObject(url, employeeDto, String.class);
		System.out.println(personResultAsJsonStr);

	}

}
