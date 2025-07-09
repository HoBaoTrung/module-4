package com.codegym.firstspringboot.repository;

import com.codegym.firstspringboot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
