package com.rondi.rabbit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rondi.mongo.model.Employee;
import com.rondi.rabbit.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public EmployeeService(EmployeeRepository repository) {
		super();
		this.repository = repository;
	}

	public void addEmployee(Employee employee) {
		this.repository.save(employee);
	}
	
	public List<Employee> getAllEmployee() {
		return this.repository.findAll();
	}

}
