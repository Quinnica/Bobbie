package com.example.binusezyfoody.model;

public class Order {

    public Drink drink;

    public int quantity;

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quntity) {
        this.quantity = quntity;
    }

    public Order(Drink drink, int quntity) {
        this.drink = drink;
        this.quantity = quntity;
    }
}
