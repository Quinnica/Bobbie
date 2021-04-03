package com.example.binusezyfoody.storage;

import com.example.binusezyfoody.model.Drink;

import java.util.ArrayList;

public class DrinkStorage {

    private static ArrayList<Drink> drinkArrayList;

    public static ArrayList<Drink> getInstance(){
        if(drinkArrayList == null) {
            drinkArrayList = new ArrayList<>();
        }
        return drinkArrayList;
    }

}
