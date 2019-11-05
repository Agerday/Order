package com.agerday.order.api;

import com.agerday.order.api.customer.CreateCustomerDto;
import com.agerday.order.api.customer.CustomerController;
import com.agerday.order.api.customer.CustomerDto;
import com.agerday.order.api.customer.CustomerMapper;
import com.agerday.order.domain.customer.CustomerRepository;
import com.agerday.order.service.CustomerService;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class CustomerControllerTest {

    private CustomerController customerController;
    private CustomerMapper customerMapper = new CustomerMapper();

    @BeforeEach
    void setUp(){
        customerController = new CustomerController(new CustomerService(new CustomerRepository()), customerMapper );
    }
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

//    @Test
//    void givenCustomerField_whenFieldIsMissing_throwException() {
//
//        CreateCustomerDto createCustomerDto = new CreateCustomerDto()
//                .withEmail("test")
//                .withAddress("test");
//
//        customerController.createCustomer(createCustomerDto);
//        exceptionRule.expect(IllegalArgumentException.class);
//        exceptionRule.expectMessage("Missing value");
//    }

    @Test
    void givenNewCustomer_whenFieldsAreNotEmpty(){
        CreateCustomerDto createCustomerDto = new CreateCustomerDto()
                .withEmail("test")
                .withAddress("test")
                .withFirstName("Jean")
                .withLastName("Poulet")
                .withPhoneNumber("0477757575");

        CustomerDto customer = customerController.createCustomer(createCustomerDto);

        Assertions.assertThat(createCustomerDto).isEqualToComparingFieldByField(customer);

    }

}