package com.rondi.rabbit.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rondi.rabbitmq.model.Employee;

@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${rondi.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${rondi.rabbitmq.routinkey}")
	private String routinkey;
	
	public void send(Employee company) {
		rabbitTemplate.convertAndSend(exchange, routinkey, company);
		System.out.println("Send msg = " + company);
	}
}
