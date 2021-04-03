package com.example.binusezyfoody.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Drink implements Serializable {

    private String name;
    private int price;

    protected Drink(Parcel in) {
        name = in.readString();
        price = in.readInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Drink(String name, int price) {
        this.name = name;
        this.price = price;
    }

}
