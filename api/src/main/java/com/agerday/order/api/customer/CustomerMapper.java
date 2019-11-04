package com.agerday.order.api.customer;

import com.agerday.order.api.customer.CustomerDto;
import com.agerday.order.domain.Customer;

public class CustomerMapper {

    public Customer toDomain(CustomerDto customerDto) {
        return new Customer(
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmail(),
                customerDto.getAddress(),
                customerDto.getPhoneNumber()
        );
    }

    public CustomerDto toDto(Customer customer) {
        return new CustomerDto()
                .withId(customer.getId())
                .withFirstName(customer.getFirstName())
                .withLastName(customer.getLastName())
                .withAddress(customer.getAddress())
                .withEmail(customer.getEmail())
                .withPhoneNumber(customer.getPhoneNumber());
    }

    public CreateCustomerDto toCreateDto(Customer customer) {
        return new CreateCustomerDto()
                .withId(customer.getId())
                .withFirstName(customer.getFirstName())
                .withLastName(customer.getLastName())
                .withAddress(customer.getAddress())
                .withEmail(customer.getEmail())
                .withPhoneNumber(customer.getPhoneNumber());
    }
}
