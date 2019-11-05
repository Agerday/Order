package com.agerday.order.api.customer;


import com.agerday.order.domain.Customer;
import com.agerday.order.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/customers")
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
    public CustomerDto createCustomer(@RequestBody CreateCustomerDto createCustomerDto) {
        if (!isValidCustomer(createCustomerDto)) {
            throw new IllegalArgumentException("Missing field");
        }
        Customer createdCustomer = customerService.addCustomer(customerMapper.toDomain(createCustomerDto));
        return customerMapper.toDto(createdCustomer);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getCustomerById(@PathVariable String id) {
        if (id == null) {
            throw new IllegalArgumentException("Id not found");
        }
        return customerMapper.toDto(customerService.getCustomerById(id));
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers()
                .stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    public boolean isValidCustomer(CreateCustomerDto createCustomerDto) {
        return (createCustomerDto.getFirstName() != null
                && createCustomerDto.getLastName() != null
                && createCustomerDto.getEmail() != null
                && createCustomerDto.getAddress() != null
                && createCustomerDto.getPhoneNumber() != null);
    }
}
