package com.davidev.service;

import com.davidev.domain.Customer;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface CustomerService {
    public List<Customer> findCustomersFilteredByStatusAndSub(MultiValueMap<String, String> filters);
}
