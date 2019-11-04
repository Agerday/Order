package com.agerday.order.api;

import com.agerday.order.api.customer.CustomerController;
import com.agerday.order.api.customer.CustomerDto;
import com.agerday.order.api.customer.CustomerMapper;
import com.agerday.order.domain.CustomerRepository;
import com.agerday.order.service.CustomerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerControllerTest {

    private CustomerController customerController;
    private CustomerMapper customerMapper;

    @BeforeEach
    void setUp(){
        customerController = new CustomerController(new CustomerService(new CustomerRepository()), customerMapper);
    }

    @Test
    void givenCustomerField_whenFieldIsMissing_returnFalse() {

        CustomerDto memberDto = new CustomerDto()
                .withEmail("test")
                .withAddress("test");
        Assertions.assertThat(customerController.isValidCustomer(customerMapper.toDomain(memberDto))).isEqualTo(false);
    }

}