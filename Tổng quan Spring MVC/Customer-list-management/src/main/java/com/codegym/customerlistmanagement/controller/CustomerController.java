package com.codegym.customerlistmanagement.controller;

import com.codegym.customerlistmanagement.model.Customer;
import com.codegym.customerlistmanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("customers/list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/customer-detail")
    public ModelAndView  showCustomerDetail(@RequestParam(required = false) String id) {
        ModelAndView modelAndView = new ModelAndView("customers/customerDetail");

        Customer customer = customerService.getCustomerById(Integer.parseInt(id));
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
}