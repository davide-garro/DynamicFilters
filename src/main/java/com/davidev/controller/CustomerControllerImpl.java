package com.davidev.controller;

import com.davidev.annotation.IllegalFilterQueryParameterException;
import com.davidev.domain.Customer;
import com.davidev.filter.FilterConfig;
import com.davidev.service.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "api/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerControllerImpl implements CustomerController{

    private final FilterConfig filterConfig;
    private final CustomerService customerService;

    public CustomerControllerImpl(FilterConfig filterConfig, CustomerService customerService) {
        this.filterConfig = filterConfig;
        this.customerService = customerService;
    }

    @Override
    @GetMapping(value = "customer/{id}")
    public Optional<Customer> getCustomerById(@RequestParam Long id) {
        return Optional.empty();
    }

    @Override
    @GetMapping
    public List<Customer> getAllCustomersWithFilters(@RequestParam MultiValueMap<String, String> filters) {
        validateFilterFields(filters.keySet(), filterConfig.getAllowedFields());
        return customerService.findCustomersFilteredByStatusAndSub(filters);
    }

    @Override
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer createCustomer(Customer customer) {
        return null;
    }

    @Override
    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    private void validateFilterFields(Set<String> providedFields, Set<String> allowedFields){
        for(String providedField : providedFields){
            if(!allowedFields.contains(providedField)){
                throw new IllegalFilterQueryParameterException("Invalid filter query parameter: " + providedField + " allowed filter parameters: " + allowedFields);
            }
        }
    }
}