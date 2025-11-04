package com.davidev.persistence;

import com.davidev.domain.Customer;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class CustomerSpecifications {

    public static Specification<Customer> hasStatus(List<String> statusList){
        return (Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder)->
        {
            if(statusList == null || statusList.isEmpty()){
                return criteriaBuilder.conjunction();
            }
            return root.get("status").in(statusList);
        };
    }
    public static Specification<Customer> hasSubscription(List<String> subscriptionList){
        return (Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder)->{
            if(subscriptionList == null || subscriptionList.isEmpty()){
                return criteriaBuilder.conjunction();
            }
            return root.get("subscription").in(subscriptionList);
        };
    }
}