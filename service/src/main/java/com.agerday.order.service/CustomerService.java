package com.agerday.order.service;


import com.agerday.order.domain.customer.Customer;
import com.agerday.order.domain.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer (Customer customer){
        return customerRepository.addCustomer(customer);
    }

    public Customer getCustomerById(String id){
        return customerRepository.getCustomerById(id);
    }

    public Collection<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }
}
