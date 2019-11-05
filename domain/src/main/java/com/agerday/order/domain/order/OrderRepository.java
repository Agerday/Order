package com.agerday.order.domain.order;

import com.agerday.order.domain.customer.Customer;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OrderRepository {
    private ConcurrentHashMap<Customer, Order> orderCustomer;

    public OrderRepository() {
        this.orderCustomer = new ConcurrentHashMap<>();
    }

    public Order makeOrder(Customer customer, Order order){
        orderCustomer.put(customer, order);
        return order;
    }
}
