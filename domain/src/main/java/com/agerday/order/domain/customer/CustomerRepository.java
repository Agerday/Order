package com.agerday.order.domain.customer;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CustomerRepository {
    private ConcurrentHashMap<String, Customer> customers;

    public CustomerRepository(){
        customers = new ConcurrentHashMap<>();
    }

    public Customer addCustomer(Customer customer){
        customers.put(customer.getId(),customer);
        return customer;
    }

    public Customer getCustomerById(String id){
       Customer foundCustomer = customers.get(id);
       return foundCustomer;
    }

    public Collection<Customer> getAllCustomers(){
        return customers.values();
    }
}

