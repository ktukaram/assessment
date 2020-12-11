package com.paypal.bfs.test.employeeserv.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;

/**
 * Implementation class for employee resource.
 */
@RestController
@RequestMapping(path = "v1/bfs/employees")
public class EmployeeResourceImpl implements EmployeeResource {

	@Autowired
	EmployeeService employeeService;

	@Override
	public ResponseEntity<Employee> employeeGetById(@PathVariable("id") String id) {
		Employee employee = null;
		if (StringUtils.isNumeric(id))
			employee = employeeService.findById(Integer.valueOf(id));
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		if (employee != null)
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);

		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Employee> createEmployee(Employee employee) {
		Employee result = employeeService.saveEmployee(employee);
		if (result != null)
			return new ResponseEntity<Employee>(result, HttpStatus.OK);
		return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
