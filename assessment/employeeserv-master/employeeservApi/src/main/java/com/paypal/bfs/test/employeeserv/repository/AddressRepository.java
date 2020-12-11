package com.paypal.bfs.test.employeeserv.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.employeeserv.api.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}
