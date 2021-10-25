package com.rondi.rabbit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rondi.mongo.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{

}
