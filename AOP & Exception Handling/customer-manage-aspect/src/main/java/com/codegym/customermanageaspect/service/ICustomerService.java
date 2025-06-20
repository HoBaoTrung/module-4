package com.codegym.customermanageaspect.service;


import com.codegym.customermanageaspect.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll() throws Exception;

    Customer findOne(Long id) throws Exception;
}
