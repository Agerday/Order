package com.agerday.order.domain.item;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {
    private ConcurrentHashMap<String, Item> items;

    public ItemRepository(){
        items = new ConcurrentHashMap<>();
    }

    public Item addItem (Item item){
        items.put(item.getId(), item);
        return item;
    }
    public Item getItemById(String id){
        Item foundItem = items.get(id);
        return foundItem;
    }
    public Collection<Item> getAllItems(){
        return items.values();
    }
}
