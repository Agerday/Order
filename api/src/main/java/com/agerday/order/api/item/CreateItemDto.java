package com.agerday.order.api.item;


public class CreateItemDto {
    private String name;
    private String description;
    private double price;
    private int amount;

    public CreateItemDto withName(String name){
        this.name=name;
        return this;
    }

    public CreateItemDto withDescription(String description){
        this.description=description;
        return this;
    }

    public CreateItemDto withPrice(double price){
        this.price=price;
        return this;
    }

    public CreateItemDto withAmount(int amount){
        this.amount=amount;
        return this;
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
