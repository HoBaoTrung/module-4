package com.codegym.customerlistmanagement.service;

import com.codegym.customerlistmanagement.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    private static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1, "Nguyen Van A", "a@gmail.com", "Sài Gòn"));
        customers.add(new Customer(2, "Tran Thi B", "b@gmail.com", "Đà Nẵng"));
        customers.add(new Customer(3, "Le Van C", "c@gmail.com", "Hà Nội"));
    }

    public static List<Customer> findAll() {
        return customers;
    }

    public static Customer getCustomerById(int id) {
        for (Customer c : customers) {
            if (c.getId() == id) return c;
        }
        return null;
    }


}
