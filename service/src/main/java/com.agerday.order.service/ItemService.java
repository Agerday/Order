package com.agerday.order.service;

import com.agerday.order.domain.item.Item;
import com.agerday.order.domain.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class ItemService {
    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item addItem (Item item){
        return itemRepository.addItem(item);
    }

    public Collection<Item> getAllItems(){
        return itemRepository.getAllItems();
    }
}
