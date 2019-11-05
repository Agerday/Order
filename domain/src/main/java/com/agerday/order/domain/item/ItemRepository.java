package com.agerday.order.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {
    private List<Item> items;

    public ItemRepository(){
        items = new ArrayList<>();
    }

    public Item addItem (Item item){
        items.add(item);
        return item;
    }


    public List<Item> getAllItems(){
        return items;
    }
}
