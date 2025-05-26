package com.codegym.customermanagermentcontroller.service;

import com.codegym.customermanagermentcontroller.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);
}
