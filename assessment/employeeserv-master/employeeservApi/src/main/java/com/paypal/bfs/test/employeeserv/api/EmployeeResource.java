package com.paypal.bfs.test.employeeserv.api;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Interface for employee resource operations.
 */
public interface EmployeeResource {

	/**
	 * Retrieves the {@link Employee} resource by id.
	 *
	 * @param id employee id.
	 * @return {@link Employee} resource.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Employee> employeeGetById(@PathVariable("id") String id);

	// ----------------------------------------------------------
	// TODO - add a new operation for creating employee resource.
	// ----------------------------------------------------------

	/**
	 * Retrieves the {@link Employee} resource by id.
	 *
	 * @param id employee id.
	 * @return {@link Employee} resource.
	 */
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Employee> createEmployee(@RequestBody Employee employee);
}
