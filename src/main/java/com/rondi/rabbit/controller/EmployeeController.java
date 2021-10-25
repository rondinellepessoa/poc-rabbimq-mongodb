package com.rondi.rabbit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rondi.mongo.model.Employee;
import com.rondi.rabbit.service.EmployeeService;

@RestController
@RequestMapping("/mongo/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(Employee employee) {
		this.service.addEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return ResponseEntity.ok().body(this.service.getAllEmployee());
	}
}
