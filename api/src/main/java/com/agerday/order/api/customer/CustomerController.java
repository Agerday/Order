package com.agerday.order.api.customer;

import com.agerday.order.domain.Customer;
import com.agerday.order.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/customers")
public class CustomerController {
    private CustomerService customerService;
    private CustomerMapper customerMapper;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto){
        if(!isValidCustomer(customerMapper.toDomain(customerDto))){
            throw new IllegalStateException("Missing field");
        }
        Customer createdCustomer = customerService.addCustomer(customerMapper.toDomain(customerDto));
        return customerMapper.toDto(createdCustomer);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getAllCustomers(){
        return customerService.getAllCustomers()
                .stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    public boolean isValidCustomer(Customer customer) {
        return (customer.getFirstName() != null
                || customer.getLastName() != null
                || customer.getEmail() != null
                || customer.getAddress() != null
                || customer.getPhoneNumber() != null);
    }
}
