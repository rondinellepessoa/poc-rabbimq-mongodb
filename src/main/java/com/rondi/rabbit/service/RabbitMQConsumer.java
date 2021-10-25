package com.rondi.rabbit.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rondi.rabbit.controller.EmployeeController;
import com.rondi.rabbitmq.model.Employee;

@Component
public class RabbitMQConsumer {

	@Autowired
	private EmployeeController controller;
	
	@RabbitListener(queues = {"${rondi.rabbitmq.queue}"})
	public void receive(Employee employee) {
		System.out.println("Message received =" + employee);
		
		com.rondi.mongo.model.Employee emp = new com.rondi.mongo.model.Employee(employee.getEmpId(), employee.getEmpName());
		controller.addEmployee(emp);
		
		System.out.println("Updating employee in mongodb!");
	}
}
