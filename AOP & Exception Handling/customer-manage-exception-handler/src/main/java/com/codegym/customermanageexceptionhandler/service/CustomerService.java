package com.codegym.customermanageexceptionhandler.service;

import com.codegym.customermanageexceptionhandler.exception.DuplicateEmailException;
import com.codegym.customermanageexceptionhandler.model.Customer;
import com.codegym.customermanageexceptionhandler.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository iCustomerRepository;

    public void save(Customer customer) throws DuplicateEmailException {
        try {
            iCustomerRepository.save(customer);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }
    }

    public List<Customer> findAll() {
        return (List<Customer>) iCustomerRepository.findAll();
    }

    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id).get();
    }

    public void remove(Integer id) {
        iCustomerRepository.deleteById(id);
    }
}
