package com.davidev.service;

import com.davidev.domain.Customer;
import com.davidev.persistence.CustomerRepository;
import java.util.List;
import com.davidev.persistence.CustomerSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;

public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findCustomersFilteredByStatusAndSub(MultiValueMap<String, String> filters) {
        Specification<Customer> specs = Specification.unrestricted();
        if(filters == null){
            return customerRepository.findAll(specs);
        }
        List<String> statusList = filters.get("status");
        List<String> subscriptionList = filters.get("subscription");

        if(statusList !=null && !statusList.isEmpty()){
            specs.and(CustomerSpecifications.hasStatus(statusList));
        }

        if(subscriptionList != null && !subscriptionList.isEmpty()){
            specs.and(CustomerSpecifications.hasSubscription(subscriptionList));
        }
        return customerRepository.findAll(specs);
    }
}
