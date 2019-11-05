package com.agerday.order.domain.order;



import com.agerday.order.domain.item.Item;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<ItemGroup> order;
    LocalDate date;
    private double totalPriceOrder;

    public Order() {
        this.order = new ArrayList<>();
        this.date = LocalDate.now();
        this.totalPriceOrder = calculateTotalPrice();
    }

    private double calculateTotalPrice() {
        List<ItemGroup> order = new ArrayList<>();
        int totalPrice = 0;
        for(ItemGroup item : order){
            totalPrice += item.getTotalPriceGroup();
        }
        return totalPrice;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order=" + order +
                ", date=" + date +
                ", totalPriceOrder=" + totalPriceOrder +
                '}';
    }
}
