package com.example.binusezyfoody.storage;

import com.example.binusezyfoody.model.Order;

import java.util.ArrayList;

public class OrderStorage {

    private static ArrayList<Order> orderArrayList;

    public static  ArrayList<Order> getInstance(){
        if(orderArrayList == null) {
            orderArrayList = new ArrayList<>();
        }
        return orderArrayList;
    }

}
