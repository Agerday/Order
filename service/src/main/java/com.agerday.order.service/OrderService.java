package com.agerday.order.service;

import com.agerday.order.domain.customer.Customer;
import com.agerday.order.domain.order.Order;
import com.agerday.order.domain.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order makeOrder(Customer customer, Order order){
        return orderRepository.makeOrder(customer, order);
    }
}
