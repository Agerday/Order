package com.agerday.order.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CustomerRepository {
    private List<Customer> customers;

    public CustomerRepository(){
        customers = new ArrayList<>();
    }

    public Customer addCustomer(Customer customer){
        if(!isValidCustomer(customer)) {
            throw new IllegalStateException("Some fields are empty, cannot add the customer.");
        }
        customers.add(customer);
        return customer;
    }

    private boolean isValidCustomer(Customer customer) {
        return (customer.getFirstName() != null
                || customer.getLastName() != null
                || customer.getEmail() != null
                || customer.getAddress() != null
                || customer.getPhoneNumber() != null);
    }

    public List<Customer> getAllCustomers(){
        return customers;
    }
}

