package com.rondi.rabbit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rondi.rabbit.service.EmployeeService;
import com.rondi.rabbit.service.RabbitMQSender;
import com.rondi.rabbitmq.model.Employee;

@RestController
@RequestMapping(value = "/rondi-rabbitmq")
public class RabbitMQWebController {

	@Autowired
	private RabbitMQSender rabbitMQSender;
	
	@Autowired
	private EmployeeService employeeService;
	//@PostMapping(value = "/producer")
	@GetMapping(value = "/producer")
	public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId) {
	//public String producer(@RequestBody Employee employee) {
		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		rabbitMQSender.send(emp);
		return "Message sent to the RabbitMQ Successfully";
	}
	
	public List<com.rondi.mongo.model.Employee> listAll(){
		return this.employeeService.getAllEmployee();
	}
}
