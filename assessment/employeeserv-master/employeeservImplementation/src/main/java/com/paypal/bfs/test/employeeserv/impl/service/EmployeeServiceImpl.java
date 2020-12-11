package com.paypal.bfs.test.employeeserv.impl.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee findById(Integer id) {
		Optional<Employee> optionalResult = employeeRepository.findById(id);
		if (optionalResult.isPresent())
			return optionalResult.get();
		return null;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		if (validateEmployee(employee))
			return employeeRepository.save(employee);
		else
			return null;
	}

	private boolean validateEmployee(Employee employee) {
		return !employee.getFirstName().isEmpty() && !employee.getLastName().isEmpty() && employee.getDob() != null
				&& employee.getAddress() != null;
	}

}
