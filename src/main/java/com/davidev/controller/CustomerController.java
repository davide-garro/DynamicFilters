package com.davidev.controller;

import com.davidev.domain.Customer;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Optional;

public interface CustomerController {
    public Optional<Customer> getCustomerById(Long id);
    public List<Customer> getAllCustomersWithFilters(MultiValueMap<String, String> filters);
    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
}
