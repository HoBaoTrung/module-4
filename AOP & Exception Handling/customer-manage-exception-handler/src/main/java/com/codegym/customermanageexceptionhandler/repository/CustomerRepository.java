package com.codegym.customermanageexceptionhandler.repository;

import com.codegym.customermanageexceptionhandler.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
