package com.agerday.order.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {
    private List<Customer> customers;

    public CustomerRepository(){
        customers = new ArrayList<>();
    }

    public Customer addCustomer(Customer customer){
        customers.add(customer);
        return customer;
    }

    public List<Customer> getAllCustomers(){
        return customers;
    }
}

