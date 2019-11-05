package com.agerday.order.domain.order;

import com.agerday.order.domain.item.Item;
import com.agerday.order.domain.item.ItemRepository;

import java.time.LocalDate;

public class ItemGroup {
    private Item item;
    private int amount;
    private LocalDate shippingDate;
    private Order order;
    private double totalPriceGroup;
    private ItemRepository itemRepository;

    public ItemGroup(String id, int amount) {
        this.item = itemRepository.getItemById(id);
        this.amount = amount;
        if(itemIsAvailable()){
            this.shippingDate = order.getDate().plusDays(1);
        }else{
            this.shippingDate = order.getDate().plusDays(7);
        }
        this.totalPriceGroup = calculateTotalPriceGroup();
    }

    private double calculateTotalPriceGroup() {
        return item.getPrice()*amount;
    }

    public double getTotalPriceGroup() {
        return totalPriceGroup;
    }

    private boolean itemIsAvailable() {
        return (item.getAmount() != 0);
    }
}
