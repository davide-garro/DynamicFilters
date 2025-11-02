package com.davidev.controller;

import com.davidev.annotation.IllegalFilterQueryParameterException;
import com.davidev.domain.Customer;
import com.davidev.filter.FilterConfig;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "api/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerControllerImpl implements CustomerController{

    private final FilterConfig filterConfig;

    public CustomerControllerImpl(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    @Override
    @GetMapping(value = "customer/{id}")
    public Optional<Customer> getCustomerById(@RequestParam Long id) {
        return Optional.empty();
    }

    @Override
    @GetMapping
    public List<Customer> getAllCustomersWithFilters(@RequestParam MultiValueMap<String, String> filters) {
        if(filters == null){
            /*return all customers*/
            return Collections.emptyList();
        }
        validateFilterFields(filters.keySet(), filterConfig.getAllowedFields());
        List<String> statuses = filters.get("status");
        List<String> subscriptions = filters.get("subscription");
        if(statuses != null){
            System.out.println("status: " + statuses);
        }
        if(subscriptions != null){
            System.out.println("subscription: " + subscriptions);
        }
        return Collections.emptyList();
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