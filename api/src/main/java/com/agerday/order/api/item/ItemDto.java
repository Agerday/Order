package com.agerday.order.api.item;

public class ItemDto {
    private String id;
    private String name;
    private String description;
    private double price;
    private int amount;

    public ItemDto withId(String id){
        this.id=id;
        return this;
    }

    public ItemDto withName(String name){
        this.name=name;
        return this;
    }

    public ItemDto withDescription(String description){
        this.description=description;
        return this;
    }

    public ItemDto withPrice(double price){
        this.price=price;
        return this;
    }

    public ItemDto withAmount(int amount){
        this.amount=amount;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
