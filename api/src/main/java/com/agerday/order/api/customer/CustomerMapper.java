package com.agerday.order.api.customer;

import com.agerday.order.domain.customer.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toDomain(CreateCustomerDto createCustomerDto) {
        return new Customer(
                createCustomerDto.getFirstName(),
                createCustomerDto.getLastName(),
                createCustomerDto.getEmail(),
                createCustomerDto.getAddress(),
                createCustomerDto.getPhoneNumber()
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

//    public CreateCustomerDto toCreateDto(Customer customer) {
//        return new CreateCustomerDto()
//                .withFirstName(customer.getFirstName())
//                .withLastName(customer.getLastName())
//                .withAddress(customer.getAddress())
//                .withEmail(customer.getEmail())
//                .withPhoneNumber(customer.getPhoneNumber());
//    }

}
